package com.company.objects.floorItems;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FloorItem {
    Point position;
    BufferedImage image;

    public FloorItem(Point position) {
        this.position = position;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void draw(Graphics g) {
        g.drawImage(image, position.x, position.y, null);
    }
}
