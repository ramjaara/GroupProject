package com.company.objects.entities;

import java.awt.*;

public class Bullet extends Entity{
    int direction;

    public Bullet(String name, Point position, int direction) {
        super(name, position);
        this.direction = direction;
        this.speed = 4;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
