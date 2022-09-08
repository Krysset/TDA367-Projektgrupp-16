package com.g16.feyrune.view.textureMap;

import com.badlogic.gdx.graphics.Color;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class TextureMapParser {
    public static TextureMap parseMapFile(String filePath) {
        Document doc = readXMLDocument(filePath);

        Node mapNode = doc.getElementsByTagName("map").item(0);
        int width = Integer.parseInt(mapNode.getAttributes().getNamedItem("width").getNodeValue());
        int height = Integer.parseInt(mapNode.getAttributes().getNamedItem("height").getNodeValue());
        int tileWidth = Integer.parseInt(mapNode.getAttributes().getNamedItem("tilewidth").getNodeValue());
        int tileHeight = Integer.parseInt(mapNode.getAttributes().getNamedItem("tileheight").getNodeValue());
        Color color;
        Node bgColorAttr = mapNode.getAttributes().getNamedItem("backgroundcolor");
        if (bgColorAttr != null) {
            String nodeVal = bgColorAttr.getNodeValue();
            // nodeVal is currently formatted #0123456 and Color.valueOf() might not expect a #
            color = new Color(Color.valueOf(nodeVal));
        } else {
            color = Color.CYAN;
        }
        List<Tileset> tilesets = generateTilesetList(doc);
        List<TextureLayer> layers = generateLayerList(doc);
        return new TextureMap(width, height, tileWidth, tileHeight, color);
    }

    private static List<TextureLayer> generateLayerList(Document doc) {
        ArrayList<TextureLayer> layers = new ArrayList<>();
        NodeList layerNodeList = doc.getElementsByTagName("layer");
        for (int i = 0; i < layerNodeList.getLength(); i++) {
            Node currentLayerNode = layerNodeList.item(i);
            // Layer node vars
            String layerName;
            int layerWidth, layerHeight;
            // Get layer node vars
            NamedNodeMap layerAttributes = currentLayerNode.getAttributes();
            layerName = layerAttributes.getNamedItem("name").getNodeValue();
            layerWidth = Integer.parseInt(layerAttributes.getNamedItem("width").getNodeValue());
            layerHeight = Integer.parseInt(layerAttributes.getNamedItem("height").getNodeValue());
            // Init layer
            TextureLayer layer = new TextureLayer(layerName, layerWidth, layerHeight);

            // Get gids and coords of layer
            NodeList layerChildNode = currentLayerNode.getChildNodes();
            for (int j = 0; j < layerChildNode.getLength(); j++) {
                Node dataNode = layerChildNode.item(j);

                if (dataNode.getNodeName().equals("data")) {
                    // Parse the CSV data.
                    String[] tileIds = dataNode.getTextContent().split(",");

                    for (int k = 0; k < tileIds.length; k++) {
                        // Prevents crashing because of whitespace or newlines when parsing integer.
                        tileIds[k] = tileIds[k].replaceAll("\\s+", "");
                        int tileId = Integer.parseInt(tileIds[k]);
                        Point coordinate = new Point(k/layerWidth, k%layerHeight);
                        layer.addTile(coordinate, tileId);
                    }
                }
            }
            layers.add(layer);
        }
        return layers;
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
