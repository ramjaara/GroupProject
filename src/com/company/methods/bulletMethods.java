package com.company.methods;

import com.company.repositories.sceneRepo;

public class bulletMethods {

    //moves bullets and checks if they have shot an enemy
    public static void bulletMove(){
        sceneRepo.bullets.forEach(Bullet -> {
            if (Bullet.isMoving()) {
                Bullet.movement();
                sceneRepo.enemies.forEach(Enemy -> {
                    if (Enemy.getHitBox().intersects(Bullet.getHitBox())) {
                        enemyMethods.kill(Enemy);
                        Bullet.stop();
                    }
                });
            }
        });
    }
}
