package com.g16.feyrune.interfaces;

public interface IAbilitable {
    /**
     * Returns the name of the ability
     * @return
     */
    String getAttackName();
    /**
     * Returns the power of the ability
     * @return the power of the ability
     */
    int getAttackPower();
    /**
     * Returns the accuracy of the ability
     * @return accuracy of the ability
     */
    int getAttackAccuracy();
}
