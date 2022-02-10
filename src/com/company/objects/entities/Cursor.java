package com.company.objects.entities;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Cursor extends Entity implements MouseMotionListener {
    boolean isDragged;

    @Override
    public void mouseDragged(MouseEvent e) {
        this.isDragged = true;
    }

    public void mouseMoved(MouseEvent e) {
        this.positionX = e.getX();
        this.positionY = e.getY();
    }

}
