package com.company;

import com.company.objects.entities.Bullet;
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
    protected List<Bullet> bullets = new ArrayList<>();

    protected Protag player;
    protected BufferedImage playerImage;

    protected Enemy enemy;
    protected BufferedImage enemyImage;

    protected BufferedImage bulletImage;

    protected KeyController keyController;
    protected MouseController mouseController;

    protected int sceneWidth = 800;
    protected int sceneHeight = 800;

    protected JLabel healthLable;

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

        healthLable = new JLabel();
        JPanel healthPanel = new JPanel();
        healthPanel.add(healthLable);

        scene.add(healthPanel);
        scene.addEntity(player);
        scene.addEntity(enemy);

        scene.repaint();
    }

    public void setScene() {
        //player
        player = new Protag("alonso", 32, 32);
        playerImage = new BufferedImage(player.getWidth(), player.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics playerGraphics = playerImage.getGraphics();
        playerGraphics.setColor(new Color(255, 0, 255));
        playerGraphics.fillRect(0, 0, 32, 32);
        player.setImage(playerImage);
        player.setPosition(400, 400);

        //healthLable.setText(String.valueOf(player.getHealth()));

        //enemy
        enemyImage = new BufferedImage(32, 32, BufferedImage.TYPE_INT_RGB);
        Graphics enemyGraphics = enemyImage.getGraphics();
        enemyGraphics.setColor(new Color(0, 255, 250));
        enemyGraphics.fillRect(0, 0, 32, 32);
        enemy = new Enemy("shifu", 32, 32);
        enemy.setImage(enemyImage);
        enemy.setPosition(500, 500);

        //bullet Image init
        bulletImage = new BufferedImage(3, 3, BufferedImage.TYPE_INT_RGB);
        Graphics bulletGraphics = bulletImage.getGraphics();
        bulletGraphics.setColor(new Color(255, 0, 0));
        bulletGraphics.fillRect(0, 0, 10, 10);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.gameLoop();
    }

    public void gameLoop() {
        long timer;
        long update_timer = 60;
        int restTimer = 0;
        int bulletNumber = 0;

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


            if (keyController.left) {
                Bullet bullet = new Bullet("bullet" + bulletNumber, player.getPositionX(), player.getPositionY(), 1);
                bullet.setImage(bulletImage);
                bullets.add(bullet);
                scene.addEntity(bullet);
                bulletNumber++;
                System.out.println(bullets);
            }

            if (keyController.up) {
                Bullet bullet = new Bullet("bullet" + bulletNumber, 100, 100, 2);
                bullet.setImage(bulletImage);
                bullets.add(bullet);
                scene.addEntity(bullet);
                bulletNumber++;
            }

            if (keyController.right) {
                Bullet bullet = new Bullet("bullet" + bulletNumber, player.getPositionX(), player.getPositionY(), 3);
                bullet.setImage(bulletImage);
                bullets.add(bullet);
                scene.addEntity(bullet);
                bulletNumber++;
            }

            if (keyController.down) {
                Bullet bullet = new Bullet("bullet" + bulletNumber, player.getPositionX(), player.getPositionY(), 4);
                bullet.setImage(bulletImage);
                bullets.add(bullet);
                scene.addEntity(bullet);
                bulletNumber++;
            }

            bullets.forEach((bullet) -> {
                if (bullet.getDirection() == 1) {
                    bullet.move(-bullet.getSpeed(), 0);
                }
                if (bullet.getDirection() == 2) {
                    bullet.move(0, -bullet.getSpeed());
                }
                if (bullet.getDirection() == 3) {
                    bullet.move(bullet.getSpeed(), 0);
                }
                if (bullet.getDirection() == 4) {
                    bullet.move(0, bullet.getSpeed());
                }
            });

            enemy.movement(player.getPositionX(), player.getPositionY());

            //cursor.move(mouseController.getMouseLocation().x,
            //        mouseController.getMouseLocation().y);

            if (restTimer == 10) {
                if (player.getHitBox().intersects(enemy.getHitBox())) {
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

            if (restTimer == 20) {
                restTimer = 0;
            }
        }
    }
}