package scanner.sax;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import scanner.dom.XmlScanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxXmlSearch {
	public static void main(String[] args) {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			SaxXnlDefaultHandler handler = new SaxXnlDefaultHandler();
			handler.setSearchEmoleId("121");
			saxParser.parse(new File(XmlScanner.FILE), handler);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
}

