package com.company.objects.entities;

import java.awt.image.BufferedImage;

public class Protag extends Entity {
    public Protag(String name, int width, int height) {
        super(name, width, height);
        this.health=(float) 10;
        this.speed = 3;
        this.hitBox.width=(width);
        this.hitBox.height=(height);
    }

    @Override
    public String toString() {
        return  health + "&" +
                name  + "&" +
                speed + "&" +
                position;
    }
}
