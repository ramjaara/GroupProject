package com.company;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseController implements MouseMotionListener {
    Point mouseLocation;

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseLocation = new Point(e.getX(), e.getY());
    }

    public Point getMouseLocation() {
        return mouseLocation;
    }
}
