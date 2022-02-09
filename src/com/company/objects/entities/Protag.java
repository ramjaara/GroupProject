package com.company.objects.entities;

import java.awt.image.BufferedImage;

public class Protag extends Entity {
    public Protag(String name, BufferedImage image) {
        super(name, image);
        this.health=(float) 10;
        this.speed = 3;
    }

    @Override
    public String toString() {
        return  health + "&" +
                name  + "&" +
                speed + "&" +
                positionX + "&" +
                positionY;
    }
}
