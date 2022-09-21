package com.g16.feyrune.interfaces;

import com.g16.feyrune.model.action.BaseAttack;

import java.util.List;

public interface ICreature {
    List<BaseAttack> getMoves(); // Should replace return type with List<IMove> when applicable
    double getHP();
    int getSpeed();
    int getPower();
    void takeDamage(int damage);
}
