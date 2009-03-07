import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;

public class SAXParse extends DefaultHandler
{
	public ArrayList<Files>	fileList = new ArrayList<Files>(0);
	public SAXParse()
	{
		parseDocument();
	}

	private void parseDocument()
	{
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try
		{

			// get a new instance of parser
			SAXParser sp = spf.newSAXParser();

			// parse the file and also register this class for call backs
			sp.parse("md5sum.xml", this);

		}
		catch (SAXException se)
		{
			se.printStackTrace();
		}
		catch (ParserConfigurationException pce)
		{
			pce.printStackTrace();
		}
		catch (IOException ie)
		{
			ie.printStackTrace();
		}
	}


	// Event Handlers
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
	{
		if (qName.equalsIgnoreCase("List"))
		{
			// create a new instance of fileList
			//fileList = new ArrayList<Files>();
		}
		else if (qName.equalsIgnoreCase("File"))
		{
			String name = attributes.getValue("name");
			String md5 = attributes.getValue("md5");
			fileList.add(new Files(name, md5));
		}
	}

	public void endElement(String uri, String localName, String qName) throws SAXException
	{
	}
}
