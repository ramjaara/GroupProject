package com.company.objects.entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    float health;
    String name;
    int speed;
    int positionX;
    int positionY;
    int height;
    int width;
    Rectangle hitBox = new Rectangle(positionX, positionY,
            width, height);
    protected BufferedImage image;

    public Entity(String name, BufferedImage image, int width, int height) {
        this.name = name;
        this.image = image;
        this.width = width;
        this.height = height;
    }

        public float getHealth () {
        return health;
    }

        public void setHealth ( float health){
        this.health = health;
    }

        public String getName () {
        return name;
    }

        public void setName (String name){
        this.name = name;
    }

        public int getSpeed () {
        return speed;
    }

        public void setSpeed ( int speed){
        this.speed = speed;
    }

        public int getPositionX () {
        return positionX;
    }

        public int getPositionY () {
        return positionY;
    }

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

    public void setPosition (int x, int y){
        this.positionX = x;
        this.positionY = y;
    }

        public void draw (Graphics g){
        g.drawImage(image, positionX, positionY, null);
    }

    public void move(int x, int y){
        this.positionX= this.positionX + x;
        this.positionY = this.positionY + y;
    }

    public boolean hitBoxCrossed(Rectangle otherHitBox){
        if(hitBox.intersects(otherHitBox)){
            return true;
        }
        return false;
    }
}

