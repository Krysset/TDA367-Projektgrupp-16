package com.g16.feyrune.model.overworld;

import com.g16.feyrune.model.player.Player;
import org.junit.Test;

import java.awt.*;
import static org.junit.Assert.assertEquals;


public class TestOverworldModel {
    @Test
    public void testMovePlayer(){
        Player player = new Player("test", new Point(20,20));
        OverworldModel om = new OverworldModel(player, "../assets/maps/plains1.tmx");
        Point test1 = player.getCoordinates();
        om.movePlayer();
        Point test2 = player.getCoordinates();
        assertEquals(test1,test2);
    }

}
