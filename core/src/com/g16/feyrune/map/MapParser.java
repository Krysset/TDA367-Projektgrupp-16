package com.g16.feyrune.map;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

/**
 * This class handle all operations related to the parsing of map files.
 */
public class MapParser {
    /**
     * This method parses a map filed (produced by Tiled).
     *
     * @param filePath The file path of the map you want to parse.
     *
     * @return Matrix of tile data.
     */
    public static void parseMapFile(String filePath) {
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

            NodeList tileNodes = doc.getElementsByTagName("tile");

            for (int i = 0; i < tileNodes.getLength(); i++) {
                Node tileNode = tileNodes.item(i);

                int id = Integer.parseInt(tileNode.getAttributes().getNamedItem("id").getNodeValue());

                NodeList tileNodeChildren = tileNode.getChildNodes();

                for (int j = 0; j < tileNodeChildren.getLength(); j++) {
                    Node tileNodeChild = tileNodeChildren.item(j);

                    for (int k = 0; k < tileNodeChild.getChildNodes().getLength(); k++) {
                        Node tileNodeChildChild = tileNodeChild.getChildNodes().item(k);

                        if (tileNodeChildChild.getAttributes() != null) {
                            if (tileNodeChildChild.getAttributes().getNamedItem("name").getNodeValue().equals("Collision")) {
                                System.out.println("Collision found at tile " + id);
                            }
                        }
                    }
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
};