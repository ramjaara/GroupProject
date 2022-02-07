package com.company;

import java.awt.event.*;

public class GameController implements KeyListener {

    public boolean up, down, left, right, action_1;

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            up = true;
        }
        if (key == KeyEvent.VK_DOWN) {
            down = true;
        }
        if (key == KeyEvent.VK_LEFT) {
            left = true;
        }
        if (key == KeyEvent.VK_RIGHT) {
            right = true;
        }

        //we have included x as well to map an action to the x key
        if (key == KeyEvent.VK_X) {
            action_1 = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            up = false;
        }
        if (key == KeyEvent.VK_DOWN) {
            down = false;
        }
        if (key == KeyEvent.VK_LEFT) {
            left = false;
        }
        if (key == KeyEvent.VK_RIGHT) {
            right = false;
        }
        if (key == KeyEvent.VK_X) {
            action_1 = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

