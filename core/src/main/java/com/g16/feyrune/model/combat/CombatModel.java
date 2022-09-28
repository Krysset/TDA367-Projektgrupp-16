package com.g16.feyrune.model.combat;

import com.g16.feyrune.controller.combat.ICombatController;
import com.g16.feyrune.interfaces.ICombatAction;
import com.g16.feyrune.interfaces.ICombatCreature;
import com.g16.feyrune.model.creature.CreatureFactory;
import com.g16.feyrune.model.player.Player;
import com.g16.feyrune.model.combat.creatures.EnemyCreature;
import com.g16.feyrune.model.combat.creatures.PlayerCreature;
import com.g16.feyrune.model.overworld.encounter.Encounter;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

public class CombatModel {
    private final Player player;
    private final ArrayList<ICombatCreature> combatCreatures;
    private ArrayList<Integer> savedCombatCreatureSpeed;
    private ArrayList<ICombatCreature> turnOrder;
    private int speedThreshold = 250;
    private boolean hasSelectedAction = true;


    public CombatModel(Player player, Encounter encounter) {
        this.player = player;
        combatCreatures = new ArrayList<>();
        savedCombatCreatureSpeed = new ArrayList<>();
        fillCombatCreatureList(player, encounter);
        generateNewAttackOrder();
    }

    public void fillCombatCreatureList(Player player, Encounter encounter) {
        combatCreatures.add(new PlayerCreature(CreatureFactory.createCreature())); // FIX: Should be player.getMonster()
        combatCreatures.add(new EnemyCreature(encounter.getEnemyCreature()[0])); //TODO: SHOUD NOT BE INDEXED LIKE THIS
        for (int i = 0; i < combatCreatures.size(); i++) {
            savedCombatCreatureSpeed.add(combatCreatures.get(i).getSpeed());
        }
    }

    public void update(){
        combatLoop();
    }

    public void combatLoop(){
        ICombatCreature actor = turnOrder.get(0);
        ICombatCreature target = choiceTarget(actor); // TODO: Replace with choose target
        ICombatAction action = actor.selectAction(target);

        // The player has not selected a action this render pass,
        // therefore stop doing the loop this current iteration.
        if (action == null) return;
        turnOrder.remove(0);
        System.out.println(getCurrentActorName(actor) + " attacked");
        System.out.println(combatCreatures.get(0).getHP() + " " + combatCreatures.get(1).getHP());
        boolean actionEndedCombat = action.executeMove(actor, target);
        generateAttackOrder();
        if (actionEndedCombat) {
            endCombat();
        }

        //TODO: remove dead creatures
        if (combatCreatures.size() == 1) {
            endCombat();
        }
    }

    private String getCurrentActorName(ICombatCreature actor) {
        if (actor instanceof PlayerCreature) {
            return "Player";
        } else {
            return "Enemy";
        }
    }

    private void endCombat(){

    }

    public void startCombatLoop() {
        while(true) {

        }
    }

    // Does not currently work if player has > 1 creature in combat
    public PlayerCreature getPlayerCreature() {
        for (ICombatCreature combatCreature : combatCreatures) {
            if (combatCreature instanceof PlayerCreature) {
                return (PlayerCreature) combatCreature;
            }
        }
        // If the player monster is not found, something is wrong
        throw new RuntimeException("Missing PlayerCreature in list of combat creatures");
    }

    //TODO: THIS IS BAD CODE NEED TO FIX AT LATER DATE
    private ICombatCreature choiceTarget(ICombatCreature actor){
        int i = combatCreatures.indexOf(actor);
        ICombatCreature target;
        if (i == combatCreatures.size() - 1) {
            target = combatCreatures.get(i);
        } else {
            target = combatCreatures.get(i + 1);
        }
        return target;
    }

    private void removeDeadCreatures() {
        for (int i = 0; i < combatCreatures.size(); i++) {
            if (combatCreatures.get(i).isDead()) {
                combatCreatures.remove(i);
            }
        }
    }


    /**
     * Generates a new turn order for the battle
     */
    private void generateNewAttackOrder() {
        turnOrder = new ArrayList<ICombatCreature>();
        generateAttackOrder();
    }

    /**
     *
     */
    private void generateAttackOrder() {
        while (turnOrder.size() < 10) {
            for (int i = 0; i < combatCreatures.size(); i++) {
                int creatureSpeed = combatCreatures.get(i).getSpeed();
                int savedCreatureSpeed = savedCombatCreatureSpeed.get(i);
                int newSavedCreatureSpeed = savedCreatureSpeed + creatureSpeed;

                if (newSavedCreatureSpeed > speedThreshold) {
                    newSavedCreatureSpeed -= speedThreshold;
                    turnOrder.add(combatCreatures.get(i));
                }

                savedCombatCreatureSpeed.set(i, newSavedCreatureSpeed);
            }
        }
    }
}
