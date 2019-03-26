package scanner.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class SaxXnlDefaultHandler extends DefaultHandler {

	private String searchEmoleId = "";

	private boolean isEmple = false;
	private boolean isLName = false;
	private boolean isFName = false;
	private boolean isBirthDay = false;
	private boolean isPosition = false;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("employee") && attributes.getValue("id").equalsIgnoreCase(searchEmoleId)) {
			isEmple = true;
		} else if (isEmple) {
			if (qName.equalsIgnoreCase("lastName")) {
				isLName = true;
			} else if (qName.equalsIgnoreCase("ferstName")) {
				isFName = true;
			} else if (qName.equalsIgnoreCase("birthDate")) {
				isBirthDay = true;
			} else if (qName.equalsIgnoreCase("position")) {
				isPosition = true;
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("employee")) {
			isEmple = false;
		} else if (isEmple) {
			if (qName.equalsIgnoreCase("lastName")) {
				isLName = false;
			} else if (qName.equalsIgnoreCase("ferstName")) {
				isFName = false;
			} else if (qName.equalsIgnoreCase("birthDate")) {
				isBirthDay = false;
			} else if (qName.equalsIgnoreCase("position")) {
				isPosition = false;
			}
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String val = new String(ch, start, length);
		if (isLName)
			System.out.println("Last name :" + val);
		else if (isFName)
			System.out.println("Ferst name :" + val);
		else if (isBirthDay)
			System.out.println("Birth date :" + val);
		else if (isPosition)
			System.out.println("Position :" + val);
	}

	public void setSearchEmoleId(String searchEmoleId) {
		this.searchEmoleId = searchEmoleId;
	}
}
