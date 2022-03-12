package com.company.objects.entities;

public class Enemy extends Entity {
    private boolean isAlive;

    public Enemy(String name, int width, int height) {
        super(name, width, height);
        this.health=(float) 5;
        this.speed = 1;
        this.hitBox.width=(width);
        this.hitBox.height=(height);
        this.isAlive = true;
    }

    public boolean isAlive(){
        return this.isAlive;
    }

    public void die(){
        this.isAlive=false;
    }

    public void movement (int protagX, int protagY){
        if(protagX<getPosition().x){
            move(-(this.speed), 0);
        }
        if(protagX>getPosition().x){
            move((this.speed), 0);
        }
        if(protagY<getPosition().y){
            move(0, -(this.speed));
        }
        if(protagY>getPosition().y){
            move(0, (this.speed));
        }
    }
}
