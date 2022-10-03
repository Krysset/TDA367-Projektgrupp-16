package com.g16.feyrune.model.combat.creatures;

import com.g16.feyrune.interfaces.ICombatAction;
import com.g16.feyrune.interfaces.ICombatCreature;
import com.g16.feyrune.interfaces.ICreature;
import com.g16.feyrune.model.combat.actions.abilities.BaseAbility;
import com.g16.feyrune.interfaces.IAbilitable;
import com.g16.feyrune.model.combat.actions.AttackAction;

import java.util.List;

public class EnemyCreature implements ICombatCreature {
    private ICreature creature;

    public EnemyCreature(ICreature creature) {
        this.creature = creature;
    }

    @Override
    public ICombatAction selectAction(ICombatCreature target) {
        return new AttackAction();
    }

    public IAbilitable getMove() {
        return creature.getMoves().get(0); // Should be random
    }

    public void takeDamage(int damage) {
        creature.takeDamage(damage);
    }


    @Override
    public List<IAbilitable> getMoves() {
        return creature.getMoves();
    }

    @Override
    public double getHP() {
        return creature.getHP();
    }

    @Override
    public int getSpeed() {
        return creature.getSpeed();
    }

    @Override
    public int attack(IAbilitable attack) {
        return creature.attack(attack);
    }

    @Override
    public boolean isDead() {
        return creature.isDead();
    }
}
