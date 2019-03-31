package scanner.dom;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

//TODO add comments
// перенести создание департаментов в отдельный метод
public class XmlScanner {
	public static final String FILE = "XmlDoc1.xml";

	public static void main(String[] args) throws Exception {
		createXmlDoc();
		//EmployeeXmlSearch.findEmloyee("120");
		EmployeeXmlSearch.findEmloyee("121");
	//	EmployeeXmlSearch.findEmloyee("122");
	}

	public static void createXmlDoc() throws Exception {

		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

		DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

		Document document = documentBuilder.newDocument();

		Element root = document.createElement("company");
		document.appendChild(root);

		Element department1 = document.createElement("department");

		root.appendChild(department1);

		department1.appendChild(createEmpl(document, "120", "Samillin", "Ignat"
				, "19.02.1991",
				"Developer"
				, new String[]{"Work for food"}, "0"));

		department1.appendChild(createEmpl(document, "121", "Kukuskin", "Valera", "01.04.1990", "Tester"
				, new String[]{"Work for food", "Sleep 2 hour"}, "120"));

		department1.appendChild(createEmpl(document, "122", "Cartoha", "Emilia", "05.12.1995", "Tester"
				, new String[]{"Work for csrtoha", "do not need to sleep"},
				"120"));

		Element department2 = document.createElement("department");

		root.appendChild(department2);

		department2.appendChild(createEmpl(document, "200", "Sirotkin", "Carnel"
				, "10.12.1993",
				"Project meneger"
				, new String[]{"I like to work"}, "0"));

		department2.appendChild(createEmpl(document, "201", "Kalisnik", "Ivan", "11.03.1992", "Tester"
				, new String[]{"I can sing for you"}, "200"));

		department2.appendChild(createEmpl(document, "202", "Joli", "Anjela", "06.10.1992", "Tester"
				, new String[]{"Do not need to sleep"},
				"200"));

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource domSource = new DOMSource(document);
		StreamResult streamResult = new StreamResult(new File(FILE));
		transformer.transform(domSource, streamResult);
	}


	public static Element createEmpl(Document document, String id,
									 String lname,
									 String fname,
									 String birth, String position, String[] skills,
									 String managerId) {
		Element empl = document.createElement("employee");
		Attr attr = document.createAttribute("id");
		attr.setValue(id);
		empl.setAttributeNode(attr);

		addTextChild(document, "lastName", lname, empl);
		addTextChild(document, "ferstName", fname, empl);
		addTextChild(document, "birthDate", birth, empl);
		addTextChild(document, "position", position, empl);
		addTextChild(document, "managerId", managerId, empl);

		Element skillsE = document.createElement("skills");
		empl.appendChild(skillsE);

		for (int i = 0; i < skills.length; i++) {
			addTextChild(document, "skill", skills[i], skillsE);
		}
		return empl;

	}

	public static void addTextChild(Document document,
									String elementName,
									String elementValue, Element el) {
		Element firstName = document.createElement(elementName);
		firstName.appendChild(document.createTextNode(elementValue));
		el.appendChild(firstName);
	}
}
