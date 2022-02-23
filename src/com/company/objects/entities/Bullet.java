package com.company.objects.entities;

public class Bullet extends Entity{
    int direction;

    public Bullet(String name, int positionX, int positionY, int direction) {
        super(name, positionX, positionY);
        this.direction = direction;
        this.speed = 4;
        this.width = 10;
        this.height = 10;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
