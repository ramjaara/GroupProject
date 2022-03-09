package com.company.methods;

import com.company.objects.entities.Enemy;
import com.company.repositories.loopRepo;
import com.company.repositories.sceneRepo;

import static com.company.repositories.sceneRepo.enemies;
import static com.company.repositories.sceneRepo.scene;

public class spawnMethods {
    public static void doSpawns(){
        if (loopRepo.spawnRate == 0) {
            sceneRepo.spawners.forEach(Spawner -> {
                if (Spawner.getAmountCreated() < Spawner.getSpawnAmount()) {
                    Enemy enemy = (Enemy) Spawner.spawn(sceneRepo.enemyImage);
                    enemies.add(enemy);
                    scene.addEntity(enemy);
                }
            });
        }
    }
}
