package com.g16.feyrune.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.g16.feyrune.enums.ModelState;
import com.g16.feyrune.interfaces.IObserver;
import com.g16.feyrune.interfaces.IScene;
import com.g16.feyrune.model.Model;
import com.g16.feyrune.view.combat.CombatScene;
import com.g16.feyrune.view.overworld.OverworldScene;

public class View implements IObserver {
    private Model model;
    private IScene currentScene;
    private OverworldScene overworldScene;
    private CombatScene combatScene;
    private SpriteBatch batch;

    /**
     * Constructor for the View
     * @param model the model to get data from
     */
    public View(Model model){
        this.model = model;
        this.model.registerNewObserver(this);


        batch = new SpriteBatch();
        overworldScene = new OverworldScene(model.getPlayer(), model.getMapManager(), batch);
        combatScene = new CombatScene(batch);

        observerUpdate(); //TODO: this is also wrong and bad :)
    }

    /**
     * Fetches new information from the model and updates the scene
     */
    public void observerUpdate(){
        ModelState currentModelState = model.getCurrentModelState();
        changeScene(currentModelState);
        currentScene.update();
    }

    /**
     * Renders the information of the current scene
     */
    public void render(){
        currentScene.render();
    }

    /**
     * Returns the sprite batch
     * @return the sprite batch
     */
    public SpriteBatch getBatch(){
        return batch;
    }

    /**
     * Changes the scene to the one corresponding to the model state
     * @param state the model state to change according to
     */
    private void changeScene(ModelState state) {
        switch (state){
            case WORLD:
                currentScene = overworldScene;
                break;
            case COMBAT:
                currentScene = combatScene;
                combatScene.renderNewCombat(model.getCombatModel(), model.getPlayer());
                break;
        }
    }

    /**
     * Returns the combatScene
     * @return the combatScene
     */
    public CombatScene getCombatScene(){
        return combatScene;
    }

    /**
     * Sets the overWorld as active scene
     */
    private void setOverWorldAsScene(){
    }

    /**
     * Sets the combatScene as active scene
     */
    private void setCombatAsScene(){
        //combatScene.renderNewCombat(); //TODO: THIS IS WHERE WE START A NEW COMBAT
    }
}

