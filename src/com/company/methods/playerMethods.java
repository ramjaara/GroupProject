package com.company.methods;

import com.company.objects.entities.Bullet;
import com.company.objects.entities.Player;
import com.company.objects.floorItems.Wall;
import com.company.repositories.loopRepo;
import com.company.repositories.sceneRepo;

import java.awt.*;

import static com.company.methods.enemyMethods.kill;

public class playerMethods {

    //shooting methods
    public static void playerShoot(Player player) {
        int bulletNumber = loopRepo.bulletNumber;
        if ((loopRepo.left || loopRepo.up ||
                loopRepo.right || loopRepo.down) && !loopRepo.hasFireCountStarted) {

            if (loopRepo.left && loopRepo.up && !loopRepo.hasShot) {
                makeBullet(player, 5, bulletNumber);
                bulletNumber++;
                loopRepo.hasShot = true;
            }
            if (loopRepo.left && loopRepo.down && !loopRepo.hasShot) {
                makeBullet(player, 6, bulletNumber);
                bulletNumber++;
                loopRepo.hasShot = true;
            }
            if (loopRepo.right && loopRepo.up && !loopRepo.hasShot) {
                makeBullet(player, 7, bulletNumber);
                bulletNumber++;
                loopRepo.hasShot = true;
            }
            if (loopRepo.right && loopRepo.down && !loopRepo.hasShot) {
                makeBullet(player, 8, bulletNumber);
                bulletNumber++;
                loopRepo.hasShot = true;
            }
            if (loopRepo.left && !loopRepo.hasShot) {
                makeBullet(player, 1, bulletNumber);
                bulletNumber++;
                loopRepo.hasShot = true;
            }
            if (loopRepo.up && !loopRepo.hasShot) {
                makeBullet(player, 2, bulletNumber);
                bulletNumber++;
                loopRepo.hasShot = true;
            }
            if (loopRepo.right && !loopRepo.hasShot) {
                makeBullet(player, 3, bulletNumber);
                bulletNumber++;
                loopRepo.hasShot = true;
            }
            if (loopRepo.down && !loopRepo.hasShot) {
                makeBullet(player, 4, bulletNumber);
                bulletNumber++;
                loopRepo.hasShot = true;
            }
            loopRepo.hasFireCountStarted = true;
            loopRepo.hasShot = false;
        }
    }

    private static void makeBullet(Player player, int direction, int bulletNumber) {
        Bullet bullet = new Bullet("bullet" + bulletNumber,
                new Point(player.getPosition().x + 16, player.getPosition().y + 16), 3, 3,
                direction);
        bullet.setImage(sceneRepo.bulletImage);
        sceneRepo.bullets.add(bullet);
        sceneRepo.scene.addEntity(bullet);
    }

    //movement methods
    public static void playerMove(Player player) {
        move(player);
    }

    private static void move(Player player) {
        //player movement
        if (loopRepo.w) {
            wallMethods.checkEntityCanMove(player);
            if (player.getCanMoveUp()) {
                player.move(0, -player.getSpeed());
            } else {
                player.move(0, player.getSpeed());
                player.resetMovement();
            }
        }

        if (loopRepo.s) {
            wallMethods.checkEntityCanMove(player);
            if (player.getCanMoveDown()) {
                player.move(0, player.getSpeed());
            }else{
                player.move(0, -player.getSpeed());
                player.resetMovement();
            }
        }

        if (loopRepo.a) {
            wallMethods.checkEntityCanMove(player);
            if (player.getCanMoveLeft()) {
                player.move(-player.getSpeed(), 0);
            } else {
                player.move(player.getSpeed(), 0);
                player.resetMovement();
            }
        }

        if (loopRepo.d) {
            wallMethods.checkEntityCanMove(player);
            if (player.getCanMoveRight()) {
                player.move(player.getSpeed(), 0);
            } else {
                player.move(-player.getSpeed(), 0);
                player.resetMovement();
            }
        }
    }

    //damage method
    public static void playerDamage(Player player) {
        if (loopRepo.damageRestTimer == 10) {
            sceneRepo.enemies.forEach(Enemy -> {
                if (player.getHitBox().intersects(Enemy.getHitBox())) {
                    player.setHealth((float) (player.getHealth() - 0.5));
                    kill(Enemy);
                }
            });
        }
    }
}

