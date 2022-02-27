package com.company.objects.entities;

public class Player extends Entity {
    int score;
    Boolean canMoveUp;
    Boolean canMoveDown;
    Boolean canMoveLeft;
    Boolean canMoveRight;

    public Player(String name, int width, int height) {
        super(name, width, height);
        this.health=(float) 10;
        this.speed = 3;
        this.hitBox.width=(width);
        this.hitBox.height=(height);
        this.score = 0;
        this.canMoveUp = true;
        this.canMoveDown = true;
        this.canMoveLeft = true;
        this.canMoveRight = true;
    }

    public Boolean getCanMoveUp() {
        return canMoveUp;
    }

    public void setCanMoveUp(Boolean canMoveUp) {
        this.canMoveUp = canMoveUp;
    }

    public Boolean getCanMoveDown() {
        return canMoveDown;
    }

    public void setCanMoveDown(Boolean canMoveDown) {
        this.canMoveDown = canMoveDown;
    }

    public Boolean getCanMoveLeft() {
        return canMoveLeft;
    }

    public void setCanMoveLeft(Boolean canMoveLeft) {
        this.canMoveLeft = canMoveLeft;
    }

    public Boolean getCanMoveRight() {
        return canMoveRight;
    }

    public void setCanMoveRight(Boolean canMoveRight) {
        this.canMoveRight = canMoveRight;
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
