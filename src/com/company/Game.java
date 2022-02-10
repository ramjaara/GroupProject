package com.company;

import com.company.objects.entities.Enemy;
import com.company.objects.entities.Entity;
import com.company.objects.entities.Protag;
import com.company.objects.entities.Cursor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Game extends JFrame {

    protected Scene scene;

    protected List<Entity> entities = new ArrayList<>();

    protected Protag player;
    protected BufferedImage playerImage;

    protected Enemy enemy;
    protected BufferedImage enemyImage;

    protected Cursor cursor;
    protected BufferedImage cursorImage;

    protected GameController controller;



    public Game(){
        // makes the window
        setTitle("Test Scene");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        scene = new Scene();
        add(scene);
        pack();

        setSize(800, 800);
        setVisible(true);

        init();
    }

    private void init(){
        controller = new GameController();
        addKeyListener(controller);
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseMoved(MouseEvent e){

            }
        });
        setScene();

        scene.addEntity(player);
        scene.addEntity(enemy);
        scene.addEntity(cursor);

        scene.repaint();
    }

    public void setScene(){
        //player
        playerImage = new BufferedImage(32, 32, BufferedImage.TYPE_INT_RGB);
        Graphics playerGraphics = playerImage.getGraphics();
        playerGraphics.setColor(new Color(255, 0, 255));
        playerGraphics.fillRect(0, 0, 32, 32);
        player = new Protag("alonso", playerImage);
        player.setPosition(0,0);

        //enemy
        enemyImage = new BufferedImage(32, 32, BufferedImage.TYPE_INT_RGB);
        Graphics enemyGraphics = enemyImage.getGraphics();
        enemyGraphics.setColor(new Color(0, 255, 250));
        enemyGraphics.fillRect(0, 0, 32, 32);
        enemy = new Enemy("shifu", enemyImage);
        enemy.setPosition(500, 500);

        //cursor
        cursorImage = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);
        Graphics cursorGraphics = cursorImage.getGraphics();
        cursorGraphics.setColor(new Color(255, 0, 0));
        cursorGraphics.fillRect(0, 0, 10, 10);
        cursor = new Cursor();
        cursor.setPosition(300, 300);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.gameLoop();
    }

    public void gameLoop() {
        long timer;

        long update_timer = 60;

        while (true) {
            timer = System.currentTimeMillis();
            if (controller.w) {
                player.move(0, -player.getSpeed());
                System.out.println(player.getPositionX() + "," + player.getPositionY());
            }
            if (controller.s) {
                player.move(0, player.getSpeed());
                System.out.println(player.getPositionX() + "," + player.getPositionY());
            }
            if (controller.a) {
                player.move(-player.getSpeed(), 0);
                System.out.println(player.getPositionX() + "," + player.getPositionY());
            }
            if (controller.d) {
                player.move(player.getSpeed(), 0);
                System.out.println(player.getPositionX() + "," + player.getPositionY());
            }

            enemy.movement(player.getPositionX(), player.getPositionY());

            cursor.setPosition(cursor.getPositionX(), cursor.getPositionY());

            update_timer -= 1;

            scene.repaint();



            //gives 60fps
            timer = (1000 / 60) - (System.currentTimeMillis() - timer);

            if (timer > 0) {
                try {
                    Thread.sleep(timer);
                } catch (Exception e) {

                }
            }
        }
    }
}