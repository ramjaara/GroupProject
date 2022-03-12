package com.company.objects.entities;

public class Player extends Entity {
    int score;

    public Player(String name, int width, int height) {
        super(name, width, height);
        this.health=(float) 10;
        this.speed = 2;
        this.hitBox.width=(width);
        this.hitBox.height=(height);
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return  health + "&" +
                name  + "&" +
                speed + "&" +
                position;
    }

    @Override
    public void ifHitsWall(String direction){
        if(direction.equals("left")){
            this.setCanMoveRight(false);
            this.move(-this.getSpeed(), 0);
        }
        if(direction.equals("right")){
            this.setCanMoveLeft(false);
            this.move(this.getSpeed(), 0);
        }
        if(direction.equals("up")){
            this.setCanMoveDown(false);
            this.move(0, -this.getSpeed());
        }
        if (direction.equals("down")){
            this.setCanMoveUp(false);
            this.move(0, this.getSpeed());
        }
    }
}
