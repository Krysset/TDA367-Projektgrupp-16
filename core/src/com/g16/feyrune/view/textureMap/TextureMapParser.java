package com.g16.feyrune.view.textureMap;

import com.sun.tools.javac.util.Pair;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class TextureMapParser {
    public static TextureMap parseMapFile(String filePath) {
        Document doc = readXMLDocument(filePath);

        Pair<Integer, Integer> mapSize = getMapSize(doc);

        List<Tileset> tilesets = generateTilesetList(doc);

        return generateTextureTileMap();
    }

    private static TextureMap generateTextureTileMap() {
        // TODO: Implement
        throw new NotImplementedException();
    }

    private static List<Tileset> generateTilesetList(Document doc) {
        ArrayList<Tileset> tilesets = new ArrayList<>();
        TilesetFactory factory = new TilesetFactory();
        NodeList tilesetNodeList = doc.getElementsByTagName("tileset");
        for (int i = 0; i < tilesetNodeList.getLength(); i++) {

            NamedNodeMap attributes = tilesetNodeList.item(i).getAttributes();
            for (int j = 0; j < attributes.getLength(); j++) {
                switch (attributes.item(j).getNodeName()) {
                    case "firstgid":
                        factory.setFirstGid(attributes.item(i).getNodeValue());
                    case "name":
                        factory.setName(attributes.item(i).getNodeValue());
                    case "tilewidth":
                        factory.setTileWidth(attributes.item(i).getNodeValue());
                    case "tileheight":
                        factory.setTileHeight(attributes.item(i).getNodeValue());
                    case "tilecount":
                        factory.setTileCount(attributes.item(i).getNodeValue());
                    case "columns":
                        factory.setColumns(attributes.item(i).getNodeValue());
                    default:
                        System.out.println("Unknown tileset attribute found while parsing: " + attributes.item(i).getNodeValue());
                }
            }
            NamedNodeMap childAttributes = tilesetNodeList.item(i).getFirstChild().getAttributes();
            for (int j = 0; j < childAttributes.getLength(); j++) {
                if (childAttributes.item(j).getNodeName().equals("source")) {
                    try {
                        factory.setImgSource(childAttributes.item(j).getNodeValue());
                    } catch (FileNotFoundException e) {
                        System.out.println("Invalid img path for tileset " + i + "th");
                    }
                }
            }
            tilesets.add(factory.createTileset());
        }
        return tilesets;
    }

    private static Pair<Integer, Integer> getMapSize(Document doc) {
        Node mapNode = doc.getElementsByTagName("map").item(0);
        int width = Integer.parseInt(mapNode.getAttributes().getNamedItem("width").getNodeValue());
        int height = Integer.parseInt(mapNode.getAttributes().getNamedItem("height").getNodeValue());
        return new Pair<>(width, height);
    }
    private static Document readXMLDocument(String filePath) {
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
