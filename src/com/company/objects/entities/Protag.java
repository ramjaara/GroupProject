package com.company.objects.entities;

public class Protag extends Entity {
    int score;

    public Protag(String name, int width, int height) {
        super(name, width, height);
        this.health=(float) 10;
        this.speed = 3;
        this.hitBox.width=(width);
        this.hitBox.height=(height);
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return  health + "&" +
                name  + "&" +
                speed + "&" +
                position;
    }
}
