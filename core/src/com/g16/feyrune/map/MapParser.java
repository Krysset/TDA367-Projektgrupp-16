package com.g16.feyrune.map;

import com.badlogic.gdx.utils.Array;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.util.ArrayList;

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

            Node mapNode = doc.getElementsByTagName("map").item(0);
            int width = Integer.parseInt(mapNode.getAttributes().getNamedItem("width").getNodeValue());
            int height = Integer.parseInt(mapNode.getAttributes().getNamedItem("height").getNodeValue());

            NodeList tileNodes = doc.getElementsByTagName("tile");

            ArrayList collisionIds = new ArrayList<Integer>();

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
                                collisionIds.add(id+1);
                            }
                        }
                    }
                }
            }

            NodeList layerNodes = doc.getElementsByTagName("layer");

            boolean[] collisionList = new boolean[width * height];

            for (int i = 0; i < layerNodes.getLength(); i++) {
                NodeList dataNodes = layerNodes.item(i).getChildNodes();

                for (int j = 0; j < dataNodes.getLength(); j++) {
                    Node dataNode = dataNodes.item(j);
                    if (dataNode.getNodeName().equals("data")) {
                        String[] tileIds = dataNode.getTextContent().split(",");
                        for (int k = 0; k < tileIds.length; k++ ) {
                            if (collisionIds.contains(Integer.parseInt(tileIds[k].replaceAll("\\s+","")))) {
                                collisionList[k] = true;
                            }
                        }
                    }
                }
            }
            boolean[][] xArray = new boolean[height][width];

            int c = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    xArray[i][j] = collisionList[c];
                    c++;
                }
            }

            System.out.println(xArray.length);

            for (boolean[] collisionX : xArray) {
                for (boolean isCollision : collisionX) {
                    if (isCollision) {
                        System.out.print("1 ");
                    } else {
                        System.out.print("0 ");
                    }
                }
                System.out.println();
            }


        } catch(Exception e) {
            e.printStackTrace();
        }
    }
};