package com.company.methods;

import com.company.objects.entities.Bullet;
import com.company.objects.entities.Player;
import com.company.repositories.loopRepo;
import com.company.repositories.sceneRepo;

import java.awt.*;

public class playerMethods {

    private static void makeBullet(Player player){
        Bullet bullet = new Bullet("bullet" + bulletNumber,
                new Point(player.getPosition().x + 16, player.getPosition().y + 16), 3, 3,
                direction);
        bullet.setImage(bulletImage);
        sceneRepo.bullets.add(bullet);
        scene.addEntity(bullet);
    }

    public static void playerShoot(Player player) {
        bulletNumber = loopRepo.bulletNumber;
        if ((loopRepo.left || loopRepo.up ||
                loopRepo.right || loopRepo.down) && !loopRepo.hasFireCountStarted) {

            if (loopRepo.left && loopRepo.up && !loopRepo.hasShot) {
                makeBullet(player, 5, bulletNumber);
                bulletNumber++;
                hasShot = true;
            }
            if (loopRepo.left && loopRepo.down && !loopRepo.hasShot) {
                makeBullet(player, 6, bulletNumber);
                bulletNumber++;
                hasShot = true;
            }
            if (loopRepo.right && loopRepo.up && !loopRepo.hasShot) {
                makeBullet(player, 7, bulletNumber);
                bulletNumber++;
                hasShot = true;
            }
            if (loopRepo.right && loopRepo.down && !loopRepo.hasShot) {
                makeBullet(player, 8, bulletNumber);
                bulletNumber++;
                hasShot = true;
            }
            if (loopRepo.left && !loopRepo.hasShot) {
                makeBullet(player, 1, bulletNumber);
                bulletNumber++;
                hasShot = true;
            }
            if (loopRepo.up && !loopRepo.hasShot) {
                makeBullet(player, 2, bulletNumber);
                bulletNumber++;
                hasShot = true;
            }
            if (loopRepo.right && !loopRepo.hasShot) {
                makeBullet(player, 3, bulletNumber);
                bulletNumber++;
                hasShot = true;
            }
            if (loopRepo.down && !loopRepo.hasShot) {
                makeBullet(player, 4, bulletNumber);
                bulletNumber++;
                hasShot = true;
            }
            loopRepo.hasFireCountStarted = true;
            loopRepo.hasShot = false;
        }
    }
}
