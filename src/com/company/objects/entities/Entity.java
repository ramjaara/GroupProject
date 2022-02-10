package com.company.objects.entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    float health;
    String name;
    int speed;
    int positionX;
    int positionY;
    protected BufferedImage image;

    public Entity(float health, String name,
                  int speed, int positionX, int positionY,
                  BufferedImage image) {
        this.health = health;
        this.name = name;
        this.speed = speed;
        this.positionX = positionX;
        this.positionY = positionY;
        this.image = image;
    }

    public Entity(String name, BufferedImage image) {
        this.name = name;
        this.image = image;
    } //the construstor for the protag

    public Entity(){

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

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPosition(int x, int y){
        this.positionX = x;
        this.positionY = y;
    }

    public void draw(Graphics g){
        g.drawImage(image , positionX, positionY, null);
    }

    public void move(int x, int y){
        this.positionX= this.positionX + x;
        this.positionY = this.positionY + y;
    }
}

