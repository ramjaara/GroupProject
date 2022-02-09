package com.company.objects.entities;

import java.awt.image.BufferedImage;

public class Enemy extends Entity {
    public Enemy(String name, BufferedImage image) {
        super(name, image);
    }

    public void movement (int protagX, int protagY){
        if(protagX<getPositionX()){
            move(-1, 0);
        }
        if(protagX>getPositionX()){
            move(1, 0);
        }
        if(protagY<getPositionY()){
            move(0, -1);
        }
        if(protagY>getPositionY()){
            move(0, 1);
        }
    }
}
