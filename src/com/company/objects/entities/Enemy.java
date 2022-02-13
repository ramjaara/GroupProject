package com.company.objects.entities;

import java.awt.image.BufferedImage;

public class Enemy extends Entity {
    public Enemy(String name, BufferedImage image, int width, int height) {
        super(name, image, width, height);
        this.health=(float) 5;
        this.speed = 2;
    }

    public void movement (int protagX, int protagY){
        if(protagX+32<getPositionX()){
            move(-(this.speed), 0);
        }
        if(protagX-32>getPositionX()){
            move((this.speed), 0);
        }
        if(protagY+32<getPositionY()){
            move(0, -(this.speed));
        }
        if(protagY-32>getPositionY()){
            move(0, (this.speed));
        }
    }
}
