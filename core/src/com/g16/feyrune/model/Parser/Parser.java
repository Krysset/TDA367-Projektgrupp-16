package com.g16.feyrune.model.Parser;

import com.g16.feyrune.map.Map;
import com.g16.feyrune.map.Tile;
import com.sun.tools.javac.util.Pair;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

/**
 * This class handle all operations related to the parsing of map files.
 */
public class Parser {
    /**
     * This method parses a map filed (produced by Tiled).
     *
     * @param filePath The file path of the map you want to parse.
     * @return A {@link Map} object containing the parsed map.
     */
    public static Map parseMapFile(String filePath) {
        Document doc = readXMLDocument(filePath);

        Pair<Integer, Integer> mapSize = getMapSize(doc);

        ArrayList<Integer> collisionIds = parseCollisionIds(doc);
        ArrayList<Integer> gIds = parseGIdList(doc);

        int[] collisionList = generateCollitionIdList(doc, collisionIds, mapSize, true);
        int[] gIdList = generateCollitionIdList(doc, gIds, mapSize, false);

        int[][] collisionMap = createIdMapFromList(collisionList, mapSize);
        int[][] gIdMap = createIdMapFromList(gIdList, mapSize);

        return generateTileMap(collisionMap, gIdMap);
    }

    /**
     * This method generates a Tile map from a collision map.
     *
     * @param collisionMap The collision map.
     * @return A {@link Map} based on the collision map.
     */
    private static Map generateTileMap(int[][] collisionMap, int[][] idMap) {
        Tile[][] tiles = new Tile[collisionMap.length][collisionMap[0].length];

        for (int i = 0; i < collisionMap.length; i++) {
            for (int j = 0; j < collisionMap[0].length; j++) {
                tiles[i][j] = new Tile(idMap[i][j], collisionMap[i][j] == 1, false);
            }
        }

        return new Map(tiles);
    }

    /**
     * This method creates a collision map from a collision list, and a map size.
     *
     * @param collisionList A list of whether a tile has collision or not.
     * @param mapSize The size of the map.
     * @return The XML document.
     */
    private static int[][] createIdMapFromList(int[] collisionList, Pair<Integer, Integer> mapSize) {
        int[][] collisionMap = new int[mapSize.snd][mapSize.fst];

        int c = 0;
        for (int i = 0; i < mapSize.snd; i++) {
            for (int j = 0; j < mapSize.fst; j++) {
                collisionMap[i][j] = collisionList[c];
                c++;
            }
        }

        return collisionMap;
    }

    /**
     * This method generates a list of whether a tile has collision or not.
     *
     * @param doc The XML document containing the map data.
     * @param gIds The list of IDs of tiles that have collision.
     * @param mapSize The size of the map.
     * @return A list of whether a tile has collision or not.
     */
    private static int[] generateCollitionIdList(Document doc, ArrayList<Integer> gIds, Pair<Integer, Integer> mapSize, boolean printBinary) {
        // Get all the layer nodes, as collisions could exist on multiple layers.
        NodeList layerNodes = doc.getElementsByTagName("layer");

        int[] collisionList = new int[mapSize.fst * mapSize.snd];
        for (int i = 0; i < layerNodes.getLength(); i++) {

            NodeList childNodes = layerNodes.item(i).getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                Node dataNode = childNodes.item(j);

                if (dataNode.getNodeName().equals("data")) {
                    // Parse the CSV data.
                    String[] tileIds = dataNode.getTextContent().split(",");

                    for (int k = 0; k < tileIds.length; k++) {
                        // Prevents crashing because of whitespace or newlines when parsing integer.
                        tileIds[k] = tileIds[k].replaceAll("\\s+", "");
                        int tileId = Integer.parseInt(tileIds[k]);
                        if (gIds.contains(tileId)) {
                            collisionList[k] = printBinary ? 1 : tileId;
                        }
                    }
                }
            }
        }

        return collisionList;
    }



    /**
     * This method parses all the tile IDs that have collision.
     *
     * @param doc The XML document containing the map data.
     * @return The list of tile IDs that have collision.
     */
    private static ArrayList<Integer> parseCollisionIds(Document doc) {
        // All the for loops are required because of "ghost" child nodes.
        // Should be investigated in case of slow performance or similar.
        // Should also be refactored for better readability.

        NodeList tileNodes = doc.getElementsByTagName("tile");

        ArrayList<Integer> collisionIds = new ArrayList<>();
        for (int i = 0; i < tileNodes.getLength(); i++) {
            Node tileNode = tileNodes.item(i);

            // Get the id of the tile node.
            int id = Integer.parseInt(tileNode.getAttributes().getNamedItem("id").getNodeValue());

            NodeList tileNodeProperties = tileNode.getChildNodes();
            for (int j = 0; j < tileNodeProperties.getLength(); j++) {
                Node properties = tileNodeProperties.item(j);

                NodeList propertiesChildNodes = properties.getChildNodes();
                for (int k = 0; k < propertiesChildNodes.getLength(); k++) {
                    Node property = propertiesChildNodes.item(k);

                    if (property.getAttributes() != null) {
                        if (property.getAttributes().getNamedItem("name").getNodeValue().equals("Collision")) {
                            // Must be +1 because the Tiled adds 1 to the id when mapping the tiles.
                            collisionIds.add(id + 1);
                        }
                    }
                }
            }
        }

        return collisionIds;
    }

    private static ArrayList<Integer> parseGIdList(Document doc){
        NodeList nodes = doc.getElementsByTagName("tileset");
        Node node = nodes.item(0);
        int tileCount = Integer.parseInt(node.getAttributes().getNamedItem("tilecount").getNodeValue());

        ArrayList<Integer> gIds = new ArrayList<>();
        for(int i = 0; i < tileCount; i++){
            gIds.add(i);
        }
        return gIds;
    }

    /**
     * This method gets the size of the map.
     *
     * @param doc The XML document containing the map data.
     * @return The size of the map as a pair of (width, height).
     */
    private static Pair<Integer, Integer> getMapSize(Document doc) {
        Node mapNode = doc.getElementsByTagName("map").item(0);
        int width = Integer.parseInt(mapNode.getAttributes().getNamedItem("width").getNodeValue());
        int height = Integer.parseInt(mapNode.getAttributes().getNamedItem("height").getNodeValue());
        return new Pair<>(width, height);
    }

    /**
     * This method reads the XML document.
     *
     * @param filePath The file path of the XML document you want to parse.
     * @return The {@link Document} containing the XML data.
     */
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