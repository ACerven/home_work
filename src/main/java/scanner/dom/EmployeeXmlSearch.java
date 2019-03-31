package scanner.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class EmployeeXmlSearch {
	public static void findEmloyee(String id) throws Exception {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(XmlScanner.FILE);

		NodeList nList = doc.getElementsByTagName("employee");

		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;

				if(id.equals( eElement.getAttribute("id"))) {
					System.out.println("Staff id : " + eElement.getAttribute("id"));
					System.out.println("First Name : " + eElement.getElementsByTagName("ferstName").item(0).getTextContent());
					System.out.println("Last Name : " + eElement.getElementsByTagName("lastName").item(0).getTextContent());
					System.out.println("Manager Id : " + eElement.getElementsByTagName("managerId").item(0).getTextContent());
					System.out.println("");
					if(!eElement.getElementsByTagName("managerId").item(0).getTextContent().equals("0"))
					findEmloyee(eElement.getElementsByTagName("managerId").item(0).getTextContent());
				}
			}
		}
	}
}
