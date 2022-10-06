package com.g16.feyrune.model.player;

import com.badlogic.gdx.graphics.Texture;
import com.g16.feyrune.interfaces.ICombatable;
import com.g16.feyrune.interfaces.IObserver;
import com.g16.feyrune.model.combat.creatures.PlayerCreature;
import com.g16.feyrune.model.creature.BaseCreature;

import com.g16.feyrune.model.creature.CreatureFactory;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private Point coordinates;
    private Texture texture;
    private ICombatable creature; //TODO: this is wrong and temp
    private List<IObserver> observers;

    /**
     * Constructor for the player
     * @param name the name of the player
     * @param coordinates the coordinates of the player
     */
    public Player(String name, Point coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        texture = new Texture("assets/hero/humanmale/humanMale.png");
        this.observers = new ArrayList<>();
        creature = CreatureFactory.createCreature();
    }

    /**
     * moves the player in the given direction
     * @param deltaX
     * @param deltaY
     */
    public void move(int deltaX, int deltaY) {
        coordinates.x += deltaX;
        coordinates.y += deltaY;
        notifyObservers();
    }

    /**
     * Sets the position of the player to (newPosX, newPosY)
     * @param newPosX
     * @param newPosY
     */
    public void setPosition(int newPosX, int newPosY) {
        coordinates.x = newPosX;
        coordinates.y = newPosY;
    }

    /**
     * Returns the player's coordinates
     * @return
     */
    public Point getCoordinates() {
        return new Point(coordinates);
    }

    /**
     * Returns the player's name
     * @return the player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the player's name to the given name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the player's texture
     * @return the player's texture
     */
    public Texture getTexture() {
        return texture;
    }

    //TODO: This is wrong and temp

    /**
     * Returns the player's creature
     * @return player.creature as a PlayerCreature
     */
    public PlayerCreature getPlayerCreature(){
        return new PlayerCreature((BaseCreature) this.creature);
    }

    /**
     * Returns a boolean representing the player's creature's alive status
     * @return
     */
    public boolean creatureIsDead() {
        return creature.isDead();
    }

    /**
     * Updates the observers connected to the player
     */
    private void notifyObservers() {
        for (IObserver observer : observers) {
            observer.observerUpdate();
        }
    }

    public void healTeam() {
        //throw new NotImplementedException();
    }
}
