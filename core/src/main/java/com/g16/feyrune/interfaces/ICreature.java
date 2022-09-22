package com.g16.feyrune.interfaces;

import java.util.List;

public interface ICreature {
    List<IMove> getMoves();
    double getHP();
    int getSpeed();
    int getPower();
    void takeDamage(int damage);
    boolean isDead();
}
