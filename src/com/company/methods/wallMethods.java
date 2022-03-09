package com.company.methods;

import com.company.objects.entities.Entity;
import com.company.objects.entities.Player;
import com.company.objects.floorItems.Wall;
import com.company.repositories.sceneRepo;

public class wallMethods {
    public static void checkEntityCanMove(Entity entity) {
        for (Wall wall : sceneRepo.walls) {
            //fix logic
            //if the player is right of the wall
            if (entity.getHitBox().intersects(wall.getBox()) &&
                    entity.getHitBox().x/*the leftmost x value of the player*/ <
                            wall.getBox().x + wall.getBox().width/*the rightmost x value of the wall*/) {
                entity.setCanMoveLeft(false);
            }
            //if player is left of the wall
            if (entity.getHitBox().intersects(wall.getBox()) &&
                    entity.getHitBox().x + entity.getHitBox().width/*the rightmost x value of the player*/ >
                            wall.getBox().x /*the leftmost x value of the wall*/) {
                entity.setCanMoveRight(false);
            }

            //player is below wall
            if (entity.getHitBox().intersects(wall.getBox()) &&
                    entity.getHitBox().y/*the leftmost x value of the player*/ <
                            wall.getBox().y + wall.getBox().height/*the rightmost x value of the wall*/) {
                entity.setCanMoveUp(false);
            }

            //player is above wall
            if (entity.getHitBox().intersects(wall.getBox()) &&
                    entity.getHitBox().y + entity.getHitBox().height/*the leftmost x value of the player*/ >
                            wall.getBox().y/*the rightmost x value of the wall*/) {
                entity.setCanMoveDown(false);
            }
        }
    }
}
