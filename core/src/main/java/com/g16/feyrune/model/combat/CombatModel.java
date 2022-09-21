package com.g16.feyrune.model.combat;

import com.g16.feyrune.model.Player;
import com.g16.feyrune.model.combat.creatures.EnemyCreature;
import com.g16.feyrune.model.combat.creatures.PlayerCreature;
import com.g16.feyrune.model.overworld.encounter.Encounter;

public class CombatModel {
    private final Player player;
    private final EnemyCreature enemyCreature;
    private final PlayerCreature playerCreature;

    public CombatModel(Player player, Encounter encounter) {
        this.player = player;
        this.enemyCreature = new EnemyCreature(encounter.getEnemyCreature());
        this.playerCreature = new PlayerCreature();
    }

    public void startCombatLoop() {

    }
}
