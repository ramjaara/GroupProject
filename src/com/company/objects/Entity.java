package com.company.objects;

public class Entity {
    float health;
    String name;
    int speed;

    public Entity(float health, String name, int speed) {
        this.health = health;
        this.name = name;
        this.speed = speed;
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

}
