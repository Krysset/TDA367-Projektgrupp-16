package com.g16.feyrune.view.overworld.textureMap;

import com.badlogic.gdx.graphics.Color;
import com.g16.feyrune.Util.Pair;
import com.g16.feyrune.Util.Parser;
import com.g16.feyrune.view.overworld.textureMap.Tileset.TilesetManager;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TextureMapParser {
    /**
     * Parses a texture map from a tmx file.
     * @param filePath The path to the tmx file.
     * @return A TextureMap object.
     */
    public static TextureMap parseMapFile(String filePath) {
        Document doc = Parser.readXMLDocument(filePath);

        Pair<Integer, Integer> mapSize = parseMapSize(doc);
        Pair<Integer, Integer> tileSize = parseTileSize(doc);

        Color bgColor = parseMapBackgroundColor(doc);

        TilesetManager tsManager = createTilesetManager(doc);

        List<TextureLayer> layers = generateLayerList(doc, mapSize, tsManager);

        return new TextureMap(mapSize.fst, mapSize.snd, tileSize.fst, tileSize.snd, bgColor, layers);
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

    /**
     * Generates a list of gIds for every tile in the map, with the first number in the list being
     * the gId of the first layer on the tile.
     * @param doc The document to parse.
     * @param mapSize The size of the map.
     * @return A list of lists of gIds.
     */
    private static List<TextureLayer> generateLayerList(Document doc, Pair<Integer, Integer> mapSize, TilesetManager tsManager) {
        // Get all the layer nodes
        NodeList layerNodes = doc.getElementsByTagName("layer");

        List<TextureLayer> layers = new ArrayList<>(5);
        // For loops are required for each child node, because shadow nodes do *apparently* exist
        // and they are not always in the same order.
        for (int i = 0; i < layerNodes.getLength(); i++) {
            TextureLayer layer = new TextureLayer();
            Node layerNode = layerNodes.item(i);
            String layerName = layerNode.getAttributes().getNamedItem("name").getNodeValue().toLowerCase();
            if (!layerName.equals("encounter")) {
                NodeList childNodes = layerNode.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node dataNode = childNodes.item(j);

                    // This checks that it is not a shadow node for the last one,
                    // if any previously were a shadow node it would not get here even
                    if (dataNode.getNodeName().equals("data")) {
                        // Parse the CSV data.
                        String[] tileIds = dataNode.getTextContent().split(",");
                        for (int k = 0; k < tileIds.length; k++) {
                            // Prevents crashing because of whitespace or newlines when parsing integer.
                            tileIds[k] = tileIds[k].replaceAll("\\s+", "");
                            int tileId = Integer.parseInt(tileIds[k]);
                            if (tileId != 0) {
                                layer.addTile(new Point(k % mapSize.fst, mapSize.snd - (k / mapSize.fst) - 1),
                                        tsManager.getITextureTileFromGId(tileId));
                            }
                        }
                    }
                }
            }
            layers.add(layer);
        }
        return layers;
    }


    /**
     * Generates a list of tilesets from the given document.
     *
     * @param doc The document to generate the tilesets from.
     * @return A list of tilesets.
     */
    private static TilesetManager createTilesetManager(Document doc) {
        TilesetManager tsManager = new TilesetManager();

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
            imgSource = relativeToAbsoluteAssets(imgSource);

            tsManager.addTileset(imgSource, name, firstGid, tileWidth, tileHeight, tileCount, columns);
        }
        return tsManager;
    }

    /**
     * Converts a relative path to an absolute path beginning in the assets folder.
     * @param relativePath The relative path to convert.
     * @return The absolute path.
     */
    private static String relativeToAbsoluteAssets(String relativePath) {
        return "assets" + relativePath.substring(2);
    }
}
