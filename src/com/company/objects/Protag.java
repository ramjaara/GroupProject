package com.company.objects;

import java.awt.image.BufferedImage;

public class Protag extends Entity{
    public Protag(String name, BufferedImage image) {
        super(name, image);
        this.health=(float) 10;
        this.speed = 5;
        this.positionX = 0;
        this.positionY = 0;
    }

    @Override
    public String toString() {
        return  health + "&" +
                name  + "&" +
                speed + "&" +
                positionX + "&" +
                positionY;
    }

    public void move(int x, int y){
        this.positionX= this.positionX + x;
        this.positionY = this.positionY + y;
    }

}
