package com.company.objects.floorItems;

import java.awt.*;

public class Wall extends FloorItem {
    Rectangle box;
    int height;
    int width;

    public Wall(Point position, int height, int width) {
        super(position);
        this.height = height;
        this.width = width;
        this.box = new Rectangle(position.x, position.y, width, height);
    }

    public Rectangle getBox() {return box;}

    public int getHeight() {return height;}

    public int getWidth() {return width;}

    @Override
    public String toString() {
        return "Wall{" +
                "position=" + position +
                ", box=" + box +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
