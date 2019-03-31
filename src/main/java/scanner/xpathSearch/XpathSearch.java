package scanner.xpath;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import scanner.dom.XmlScanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import java.util.ArrayList;
import java.util.List;

public class XpathSearch {
	public static void main(String[] args) throws Exception {
		//Get DOM Node for XML;
		Document document = getDocument(XmlScanner.FILE);

		//Get all employee ids
		System.out.println(evaluateXPath(document, "/company/department/employee"));

		System.out.println(evaluateXPath(document, "/company/department/employee/skills"));

	}

	private static List<String> evaluateXPath(Document document, String xpathExpression) throws Exception {
		// Create XPathFactory object
		XPathFactory xpathFactory = XPathFactory.newInstance();

		// Create XPath object
		XPath xpath = xpathFactory.newXPath();

		List<String> values = new ArrayList<>();
		try {
			// Create XPathExpression object
			XPathExpression expr = xpath.compile(xpathExpression);

			// Evaluate expression result on XML document
			NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);

			// check if note exist
			//  check tag presence, check that tag contains children (not simple text node, but nested tags)
			if (nodes == null && nodes.getLength() <= 0) {
				return values;
			}

			for (int i = 0; i < nodes.getLength(); i++) {
				NodeList childNodes = nodes.item(i).getChildNodes();
				for (int j = 0; j < childNodes.getLength(); j++) {
					Node item = childNodes.item(j);
					if (item.getNodeType() == Node.ELEMENT_NODE)
						values.add(item.getNodeName() + " " + item.getTextContent());
				}
//				values.add(nodes.item(i).getNodeValue());
			}

		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		// return list of values for specified tag
		return values;
	}

	private static Document getDocument(String fileName) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(fileName);
		return doc;
	}
}
