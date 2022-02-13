package com.company;

import com.company.objects.entities.Enemy;
import com.company.objects.entities.Entity;
import com.company.objects.entities.Protag;

import javax.swing.*;
import java.awt.*;
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

    protected Enemy cursor;
    protected BufferedImage cursorImage;

    protected KeyController keyController;
    protected MouseController mouseController;

    protected int sceneWidth = 800;
    protected int sceneHeight = 800;

    public Game() {
        // makes the window
        setTitle("Test Scene");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        scene = new Scene();
        add(scene);
        pack();

        setSize(sceneWidth, sceneHeight);
        setVisible(true);

        init();
    }

    private void init() {
        keyController = new KeyController();
        mouseController = new MouseController();
        addKeyListener(keyController);
        addMouseMotionListener(mouseController);

        setScene();

        scene.addEntity(player);
        scene.addEntity(enemy);

        scene.repaint();
    }

    public void setScene() {
        //player
        player = new Protag("alonso", playerImage, 32, 32);
        playerImage = new BufferedImage(player.getWidth(), player.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics playerGraphics = playerImage.getGraphics();
        playerGraphics.setColor(new Color(255, 0, 255));
        playerGraphics.fillRect(0, 0, 32, 32);
        player.setPosition(0, 0);

        //enemy
        enemyImage = new BufferedImage(32, 32, BufferedImage.TYPE_INT_RGB);
        Graphics enemyGraphics = enemyImage.getGraphics();
        enemyGraphics.setColor(new Color(0, 255, 250));
        enemyGraphics.fillRect(0, 0, 32, 32);
        enemy = new Enemy("shifu", enemyImage, 32, 32);
        enemy.setPosition(500, 500);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.gameLoop();
    }

    public void gameLoop() {
        long timer;

        long update_timer = 60;

        int restTimer = 0;

        while (true) {
            timer = System.currentTimeMillis();
            if (keyController.w) {
                if (player.getPositionY() > 0) {
                    player.move(0, -player.getSpeed());
                }
                System.out.println(player.getPositionX() + "," + player.getPositionY());
            }
            if (keyController.s) {
                if (player.getPositionY() < sceneHeight - 50)
                    player.move(0, player.getSpeed());
                System.out.println(player.getPositionX() + "," + player.getPositionY());
            }
            if (keyController.a) {
                if (player.getPositionX() > 0) {
                    player.move(-player.getSpeed(), 0);
                }
                System.out.println(player.getPositionX() + "," + player.getPositionY());
            }
            if (keyController.d) {
                if (player.getPositionX() < sceneWidth - 32) {
                    player.move(player.getSpeed(), 0);
                }
                System.out.println(player.getPositionX() + "," + player.getPositionY());
            }

            enemy.movement(player.getPositionX(), player.getPositionY());

            //cursor.move(mouseController.getMouseLocation().x,
            //        mouseController.getMouseLocation().y);
            if (restTimer == 25) {
                if ((player.getPositionX()==enemy.getPositionX())) {
                    player.setHealth((float) (player.getHealth() - 0.5));
                    System.out.println("DAMAGE");
                    System.out.println(player.getHealth());
                }
                if ((player.getPositionY()==enemy.getPositionY())) {
                    player.setHealth((float) (player.getHealth() - 0.5));
                    System.out.println("DAMAGE");
                    System.out.println(player.getHealth());
                }
            }

            update_timer -= 1;

            if (player.getHealth() <= 0) {
                System.out.println("GAME OVER");
                System.exit(0);
            }

            scene.repaint();

            //gives 60fps
            timer = (1000 / 60) - (System.currentTimeMillis() - timer);

            if (timer > 0) {
                try {
                    Thread.sleep(timer);
                } catch (Exception e) {

                }
            }
            restTimer++;

            if (restTimer == 50) {
                restTimer = 0;
            }
        }
    }
}