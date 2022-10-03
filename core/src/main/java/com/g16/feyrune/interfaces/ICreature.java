package com.g16.feyrune.interfaces;

import java.util.List;

public interface ICreature {
    List<IAbility> getMoves();
    double getHP();
    int getSpeed();
    int getPower();
    int getDefense();
    void takeDamage(int damage);
    boolean isDead();
}
