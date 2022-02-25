package com.company.objects.entities;

import java.awt.*;

public class Bullet extends Entity {
    private int direction;
    private boolean isMoving;

    public Bullet(String name, Point position, int width, int height, int direction) {
        super(name, position, width, height);
        this.hitBox = new Rectangle(position.x, position.y, width, height);
        this.direction = direction;
        this.speed = 4;
        this.isMoving = true;
    }

    public void stop(){
        this.isMoving = false;
        this.setPosition( new Point(1000, 1000));
    }

    public boolean isMoving(){return this.isMoving;}

    public int getDirection() {return direction;}

    public void setDirection(int direction) {this.direction = direction;}

    public void movement() {
        //left
        if (this.direction == 1) {this.move(-this.speed, 0);}
        //up
        if (this.direction == 2) {this.move(0, -this.speed);}
        //right
        if (this.direction == 3) {this.move(this.speed, 0);}
        //down
        if (this.direction == 4) {this.move(0, this.speed);}
        //left and up
        if (this.direction == 5) {this.move(-this.speed, -this.speed);}
        //left and down
        if (this.direction == 6) {this.move(-this.speed, this.speed);}
        //right and up
        if (this.direction == 7) {this.move(this.speed, -this.speed);}
        //right and down
        if (this.direction == 8) {this.move(this.speed, this.speed);}
    }
}
