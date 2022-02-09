package com.company.objects;

public class Protag extends Entity{
    public Protag(String name) {
        super(name);
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
        setPosition(getPositionX()+x, getPositionY()+y);
    }

}
