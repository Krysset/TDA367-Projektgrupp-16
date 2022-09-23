package com.g16.feyrune.model.combat.creatures;

import com.g16.feyrune.model.combat.actions.ICombatAction;
import com.g16.feyrune.model.creature.ICreature;
import com.g16.feyrune.model.combat.ability.BaseAttack;
import com.g16.feyrune.model.combat.ability.IAbility;

import java.util.List;

public class EnemyCreature implements ICombatCreature {
    private ICreature creature;

    public EnemyCreature(ICreature creature) {
        this.creature = creature;
    }

    @Override
    public ICombatAction selectAction(ICombatCreature actor, ICombatCreature target) {
        return null;
    }

    public IAbility getMove() {
        return creature.getMoves().get(0); // TODO: Should be random
    }

    public void takeDamage(int damage) {
        creature.takeDamage(damage);
    }

    // TODO: Should be renamed to something more appropriate
    private IAbility createNewMoveUsingPower(IAbility move) {
        return new BaseAttack(move.getAttackAccuracy(), move.getAttackPower() + creature.getPower(), move.getAttackName());
    }

    @Override
    public List<IAbility> getMoves() {
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
    public int getPower() {
        return creature.getPower();
    }

    @Override
    public boolean isDead() {
        return creature.isDead();
    }
}
