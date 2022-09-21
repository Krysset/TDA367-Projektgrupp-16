package com.g16.feyrune.model.combat.creatures;

import com.g16.feyrune.interfaces.ICreature;
import com.g16.feyrune.model.action.BaseAttack;

public class EnemyCreature {
    private ICreature creature;

    public EnemyCreature(ICreature creature) {
        this.creature = creature;
    }

    public BaseAttack getMove() {
        return creature.getMoves().get(0); // Should be random
    }

    public void takeDamage(int damage) {
        creature.takeDamage(damage);
    }

    public boolean isDead() {
        return creature.getHP() <= 0;
    }

    // Should be renamed to something more appropriate
    private BaseAttack createNewMoveUsingPower(BaseAttack move) {
        return new BaseAttack(move.getAccuracy(), move.getPower() + creature.getPower(), move.getName());
    }
}
