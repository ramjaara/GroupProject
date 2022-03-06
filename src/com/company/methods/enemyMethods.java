package com.company.methods;

import com.company.objects.entities.Enemy;
import com.company.objects.entities.Player;
import com.company.repositories.sceneRepo;

import java.awt.*;



public class enemyMethods {
    public static void kill(Enemy enemy) {
        sceneRepo.scene.removeEntity(enemy);
        enemy.setPosition(new Point(1000, 1000));
        enemy.die();
    }

    //checks if each enemy is alive then moves them
    public static void enemyMove(Player player){
        sceneRepo.enemies.forEach(Enemy ->
        {
            if (Enemy.isAlive()) {
                Enemy.movement(player.getPosition().x, player.getPosition().y);
            }
        });
    }
}
