package com.company.objects.entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    float health;
    String name;
    int speed;
    Point position = new Point(0, 0);
    int height;
    int width;
    Rectangle hitBox = new Rectangle(position.x, position.y,
            width, height);
    protected BufferedImage image;

    //empty constructor
    public Entity(){}

    //regular entity constructor(i.e player/enemy)
    public Entity(String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }

    //bullet constructor
    public Entity(String name, Point position, int width, int height){
        this.name = name;
        this.position = position;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {this.speed = speed;}

    public Point getPosition(){return position;}

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Rectangle getHitBox() {
        return hitBox;
    }

    public void setPosition(Point position){
        this.position = position;
        this.hitBox.x = position.x;
        this.hitBox.y = position.y;
    }

    public void draw(Graphics g) {
        g.drawImage(image, position.x, position.y, null);
    }

    public void move(int x, int y) {
        this.position.x = this.position.x + x;
        this.position.y = this.position.y + y;
        this.hitBox.x = this.position.x;
        this.hitBox.y = this.position.y;
    }
}

