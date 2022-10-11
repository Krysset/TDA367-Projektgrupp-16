package com.g16.feyrune.interfaces;

import java.util.List;

public interface ICombatable {//TODO: separate to a smaller interface, interface segregation principle
    /**
     * @return the list of moves that the creature can use
     */
    List<IAbilitable> getMoves();
    /**
     * @return the speed of the creature (used to calculate turn order in combat
     */
    int getSpeed();
    /**
     * @param attack the attack to calculate the damage of
     * @return the damage of the attack
     */
    int calculateAttack(IAbilitable attack);
    /**
     * damages the creature by the given amount
     * @param damage the amount of damage to take
     */
    void takeDamage(int damage);
    /**
     * @return if the creature is dead or not
     */
    boolean isDead();

    double getHP();

}
