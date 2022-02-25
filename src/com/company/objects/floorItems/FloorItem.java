package com.company.objects.floorItems;

import java.awt.*;

public class FloorItem {
    Point position;

    public FloorItem(Point position) {
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
}
