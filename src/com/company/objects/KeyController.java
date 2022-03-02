package com.company.objects;

import java.awt.event.*;

public class KeyController implements KeyListener{

    public boolean up, down, left, right, action_1;
    public boolean w, a, s, d;

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
        if (key == KeyEvent.VK_W) {
            w = true;
        }
        if (key == KeyEvent.VK_A) {
            a = true;
        }
        if (key == KeyEvent.VK_S) {
            s = true;
        }
        if (key == KeyEvent.VK_D) {
            d = true;
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
        if (key == KeyEvent.VK_W) {
            w = false;
        }
        if (key == KeyEvent.VK_A) {
            a = false;
        }
        if (key == KeyEvent.VK_S) {
            s = false;
        }
        if (key == KeyEvent.VK_D) {
            d = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

