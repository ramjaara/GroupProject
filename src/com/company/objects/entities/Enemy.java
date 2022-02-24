package com.company.objects.entities;

import java.awt.image.BufferedImage;

public class Enemy extends Entity {
    public Enemy(String name, int width, int height) {
        super(name, width, height);
        this.health=(float) 5;
        this.speed = 2;
        this.hitBox.width=(width);
        this.hitBox.height=(height);
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
