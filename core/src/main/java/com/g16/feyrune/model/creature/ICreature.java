package com.g16.feyrune.model.creature;

import com.g16.feyrune.model.combat.ability.IAbility;

import java.util.List;

public interface ICreature {
    List<IAbility> getMoves();
    double getHP();
    int getSpeed();
    int getPower();
    void takeDamage(int damage);
    boolean isDead();
}
