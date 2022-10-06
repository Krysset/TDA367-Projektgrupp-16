package com.g16.feyrune.model.combat.creatures;


import com.g16.feyrune.interfaces.IAbilitable;
import com.g16.feyrune.interfaces.ICombatAction;
import com.g16.feyrune.model.creature.BaseCreature;

import java.util.List;

public abstract class CombatCreature {
    protected final BaseCreature creature;
    protected ICombatAction selectedAction;

    public CombatCreature(BaseCreature creature) {
        this.creature = creature;
    }

    public List<IAbilitable> getMoves() {
        return creature.getMoves();
    }

    public int getSpeed() {
        return creature.getSpeed();
    }

    public int calculateAttack(IAbilitable attack) {
        return creature.calculateAttack(attack);
    }


    public void takeDamage(int damage) {
        creature.takeDamage(damage);
    }

    public boolean isDead() {
        return creature.isDead();
    }

    public double getHP(){
        return creature.getHP();
    }

    public int getPower(){
        return creature.getPower();
    }

    public abstract ICombatAction selectAction(CombatCreature target);

}
