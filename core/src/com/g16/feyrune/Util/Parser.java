package com.g16.feyrune.Util;

import org.w3c.dom.Document;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Parser {
    /**
     * This method reads an XML document.
     *
     * @param filePath The file path of the XML document you want to parse.
     * @return The {@link Document} containing the XML data.
     */
    public static Document readXMLDocument(String filePath) {
        // Most of the information writing this parser was gotten from this tutorial:
        // https://mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/

        // Create a new document builder factory.
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            // Safely parse XML file.
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(filePath));

            // Normalizes the document tree for better parsing.
            // More info:
            // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            return doc;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
