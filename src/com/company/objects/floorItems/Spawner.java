package com.company.objects.floorItems;

import com.company.objects.entities.Enemy;
import com.company.objects.entities.Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Spawner extends FloorItem {
    private String type;
    private int spawnAmount;
    private int amountCreated;

    public Spawner(Point position, String type, int spawnAmount) {
        super(position);
        this.type = type;
        this.spawnAmount = spawnAmount;
        this.amountCreated = 0;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSpawnAmount() {
        return spawnAmount;
    }

    public void setSpawnAmount(int spawnAmount) {
        this.spawnAmount = spawnAmount;
    }

    public int getAmountCreated() {
        return amountCreated;
    }

    public Entity spawn(BufferedImage image) {
        if (this.type.equals("Enemy")) {
            Enemy enemy = new Enemy("enemy", 32, 32);
            enemy.setPosition(new Point(this.position.x, this.position.y));
            enemy.setImage(image);
            amountCreated++;
            return enemy;
        }
        return new Entity();
    }
}
