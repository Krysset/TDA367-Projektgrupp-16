package com.g16.feyrune.interfaces;

import java.util.List;

public interface ICreature {//TODO: separate to a smaller interface, interface segregation principle
    List<IAbilitable> getMoves();
    int getSpeed();
    int attack(IAbilitable attack);
    void takeDamage(int damage);
    boolean isDead();
}
