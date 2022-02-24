package com.company.objects.entities;

import java.awt.*;

public class Bullet extends Entity {
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

    public void movement() {
        //left
        if (this.direction == 1) {
            this.move(-this.speed, 0);
        }
        //up
        if (this.direction == 2) {
            this.move(0, -this.speed);
        }
        //right
        if (this.direction == 3) {
            this.move(this.speed, 0);
        }
        //down
        if (this.direction == 4) {
            this.move(0, this.speed);
        }
        //left and up
        if (this.direction == 5) {
            this.move(-this.speed, -this.speed);
        }
        //left and down
        if (this.direction == 6) {
            this.move(-this.speed, this.speed);
        }
        //right and up
        if (this.direction == 7) {
            this.move(this.speed, -this.speed);
        }
        //right and down
        if (this.direction == 8) {
            this.move(this.speed, this.speed);
        }
    }
}
