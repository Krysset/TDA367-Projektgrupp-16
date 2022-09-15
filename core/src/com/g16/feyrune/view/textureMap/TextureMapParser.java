package com.g16.feyrune.view.textureMap;

import com.badlogic.gdx.graphics.Color;
import com.g16.feyrune.Util.Pair;
import com.g16.feyrune.Util.Parser;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class TextureMapParser {
    public static TextureMap parseMapFile(String filePath) {
        Document doc = Parser.readXMLDocument(filePath);

        Pair<Integer, Integer> mapSize = parseMapSize(doc);
        Pair<Integer, Integer> tileSize = parseTileSize(doc);

        List<Tileset> tilesets = generateTilesetList(doc);

        int[][] gIdList = generateGIdList(doc, mapSize);
        int[][][] gIdMap = createIdMapFromList(gIdList, mapSize);

        Color bgColor = parseMapBackgroundColor(doc);

        return new TextureMap(mapSize.fst, mapSize.snd, tileSize.fst, tileSize.snd, bgColor, tilesets, gIdMap);
    }

    private static Pair<Integer, Integer> parseMapSize(Document doc) {
        Node mapNode = getMapNode(doc);
        int width = Integer.parseInt(mapNode.getAttributes().getNamedItem("width").getNodeValue());
        int height = Integer.parseInt(mapNode.getAttributes().getNamedItem("height").getNodeValue());
        return new Pair<>(width, height);
    }

    private static Pair<Integer, Integer> parseTileSize(Document doc) {
        Node mapNode = getMapNode(doc);
        int width = Integer.parseInt(mapNode.getAttributes().getNamedItem("tilewidth").getNodeValue());
        int height = Integer.parseInt(mapNode.getAttributes().getNamedItem("tileheight").getNodeValue());
        return new Pair<>(width, height);
    }

    private static Color parseMapBackgroundColor(Document doc) {
        Node mapNode = getMapNode(doc);

        Color color;
        Node bgColorAttr = mapNode.getAttributes().getNamedItem("backgroundcolor");
        if (bgColorAttr != null) {
            String nodeVal = bgColorAttr.getNodeValue();
            // nodeVal is currently formatted #0123456 and Color.valueOf() might not expect a #
            color = new Color(Color.valueOf(nodeVal));
        } else {
            color = Color.CYAN;
        }

        return color;
    }

    private static Node getMapNode(Document doc) {
        return doc.getElementsByTagName("map").item(0);
    }

    private static int[][] generateGIdList(Document doc, Pair<Integer, Integer> mapSize) {
        // Get all the layer nodes, as collisions could exist on multiple layers.
        NodeList layerNodes = doc.getElementsByTagName("layer");

        int[][] gIdList = new int[mapSize.fst * mapSize.snd][layerNodes.getLength()];
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
                        gIdList[k][i] = tileId;
                    }
                }
            }
        }

        return gIdList;
    }

    /**
     * This method creates a collision map from a collision list, and a map size.
     *
     * @param gIdList A list of whether a tile has collision or not.
     * @param mapSize The size of the map.
     * @return The XML document.
     */
    private static int[][][] createIdMapFromList(int[][] gIdList, Pair<Integer, Integer> mapSize) {
        int[][][] gIdMap = new int[mapSize.snd][mapSize.fst][gIdList[0].length];

        int c = 0;
        for (int i = mapSize.snd - 1; i >= 0; i--) {
            for (int j = 0; j < mapSize.fst; j++) {
                gIdMap[i][j] = gIdList[c];
                c++;
            }
        }

        return gIdMap;
    }

    /**
     * Generates a list of tilesets from the given document.
     *
     * @param doc The document to generate the tilesets from.
     * @return A list of tilesets.
     */
    private static List<Tileset> generateTilesetList(Document doc) {
        ArrayList<Tileset> tilesets = new ArrayList<>();

        NodeList tilesetNodeList = doc.getElementsByTagName("tileset");
        for (int i = 0; i < tilesetNodeList.getLength(); i++) {
            NamedNodeMap attributes = tilesetNodeList.item(i).getAttributes();

            String name = attributes.getNamedItem("name").getNodeValue();
            int firstGid = Integer.parseInt(attributes.getNamedItem("firstgid").getNodeValue());
            int tileWidth = Integer.parseInt(attributes.getNamedItem("tilewidth").getNodeValue());
            int tileHeight = Integer.parseInt(attributes.getNamedItem("tileheight").getNodeValue());
            int tileCount = Integer.parseInt(attributes.getNamedItem("tilecount").getNodeValue());
            int columns = Integer.parseInt(attributes.getNamedItem("columns").getNodeValue());

            Node imageNode = tilesetNodeList.item(i).getChildNodes().item(1);
            String imgSource = imageNode.getAttributes().getNamedItem("source").getNodeValue();
            imgSource = relativeToAbsolute(imgSource);

            tilesets.add(new Tileset(imgSource, name, firstGid, tileWidth, tileHeight, tileCount, columns));
        }
        return tilesets;
    }

    /**
     * Converts a relative path to an absolute path beginning in the assets folder.
     * @param relativePath The relative path to convert.
     * @return The absolute path.
     */
    private static String relativeToAbsolute(String relativePath) {
        return "assets" + relativePath.substring(5);
    }
}
