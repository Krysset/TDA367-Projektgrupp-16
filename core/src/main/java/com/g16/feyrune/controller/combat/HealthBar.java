package com.g16.feyrune.controller.combat;

public class HealthBar {
    private int maxHealth;
    private int currentHealth;

    public HealthBar(int maxHealth){
        this.maxHealth = maxHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void render(){
        //TODO: NOT IMPLEMENTED
    }
}
