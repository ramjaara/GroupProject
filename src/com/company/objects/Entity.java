package com.company.objects;

public class Entity {
    float health;
    String name;
    int speed;
    int positionX;
    int positionY;

    public Entity(float health, String name, int speed, int positionX, int positionY) {
        this.health = health;
        this.name = name;
        this.speed = speed;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public Entity(String name) {
        this.name = name;
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

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}

