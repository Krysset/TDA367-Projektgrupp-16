package com.g16.feyrune.model.combat.creatures;

import com.g16.feyrune.interfaces.ICombatAction;
import com.g16.feyrune.interfaces.ICombatCreature;
import com.g16.feyrune.interfaces.ICreature;
import com.g16.feyrune.model.action.BaseAttack;
import com.g16.feyrune.interfaces.IMove;

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

    public IMove getMove() {
        return creature.getMoves().get(0); // Should be random
    }

    public void takeDamage(int damage) {
        creature.takeDamage(damage);
    }

    // Should be renamed to something more appropriate
    private IMove createNewMoveUsingPower(IMove move) {
        return new BaseAttack(move.getAttackAccuracy(), move.getAttackPower() + creature.getPower(), move.getAttackName());
    }

    @Override
    public List<IMove> getMoves() {
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
