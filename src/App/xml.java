/*
this code is from stack OverFlow site:
https://stackoverflow.com/questions/23951132/a-simple-example-of-txt-to-xml-with-java
the name of the writer is kurtiss.
and I made some changes to the code.
 */
//this class convert a txt file to xml file
package App;
import java.io.*;

import org.xml.sax.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.sax.*;

public class xml {

    BufferedReader reader;
    StreamResult result;
    TransformerHandler transformer;

    public static void main(String args[]) {
        //call the  convert function to convert the txt file to xml file.
        new xml().convert();
    }

    public void convert() {
        try {
            //read a txt file (data.txt)
            reader = new BufferedReader(new FileReader("data.txt"));
            //the converted file called "data.xml "
            result = new StreamResult("data.xml");
            openXml();
            //read the txt file.
            String string;
            while ((string = reader.readLine()) != null) {
                process(string);
            }
            //close the both files.
            reader.close();
            closeXml();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//this funvtion transform the txt file to xml file
    public void openXml() throws ParserConfigurationException, TransformerConfigurationException, SAXException {

        SAXTransformerFactory saxTransformerFactory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
        transformer = saxTransformerFactory.newTransformerHandler();

        // pretty XML output
        Transformer serializer = transformer.getTransformer();
        serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setResult(result);
        transformer.startDocument();
        transformer.startElement(null, null, "inserts", null);
    }
//
    public void process(String s) throws SAXException {
        transformer.startElement(null, null, "option", null);
        transformer.characters(s.toCharArray(), 0, s.length());
        transformer.endElement(null, null, "option");
    }

    public void closeXml() throws SAXException {
        transformer.endElement(null, null, "inserts");
        transformer.endDocument();
    }
}

