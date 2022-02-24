package com.company;

import com.company.objects.entities.Bullet;
import com.company.objects.entities.Enemy;
import com.company.objects.entities.Protag;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Game extends JFrame {

    protected Scene scene;

    protected JLabel background;
    protected BufferedImage backgroundImage;

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

        healthLable = new JLabel("");
        healthLable.setOpaque(true);

        scene.add(healthLable);
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
        player.setPosition(new Point(200, 200));

        //enemy
        enemyImage = new BufferedImage(32, 32, BufferedImage.TYPE_INT_RGB);
        Graphics enemyGraphics = enemyImage.getGraphics();
        enemyGraphics.setColor(new Color(0, 255, 250));
        enemyGraphics.fillRect(0, 0, 32, 32);
        enemy = new Enemy("shifu", 32, 32);
        enemy.setImage(enemyImage);
        enemy.setPosition(new Point(200, 200));

        //bullet Image init
        bulletImage = new BufferedImage(3, 3, BufferedImage.TYPE_INT_RGB);
        Graphics bulletGraphics = bulletImage.getGraphics();
        bulletGraphics.setColor(new Color(255, 0, 0));
        bulletGraphics.fillRect(0, 0, 10, 10);
    }

    public void makeBullet(int direction, int bulletNumber) {
        Bullet bullet = new Bullet("bullet" + bulletNumber,
                new Point(player.getPosition().x + 16, player.getPosition().y + 16),
                direction);
        bullet.setImage(bulletImage);
        bullets.add(bullet);
        scene.addEntity(bullet);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.gameLoop();
    }

    public void gameLoop() {
        long timer;
        int restTimer = 0;
        int bulletNumber = 0;
        boolean hasShot = false;
        boolean hasFireCountStarted = false;
        int fireCount = 0;
        int fireRate = 10;

        while (true) {
            timer = System.currentTimeMillis();

            healthLable.setText(String.valueOf(player.getHealth()));

            //player movement
            if (keyController.w) {
                if (player.getPosition().y > 0) {
                    player.move(0, -player.getSpeed());
                }
            }

            if (keyController.s) {
                if (player.getPosition().y < sceneHeight - 50)
                    player.move(0, player.getSpeed());
            }

            if (keyController.a) {
                if (player.getPosition().x > 0) {
                    player.move(-player.getSpeed(), 0);
                }
            }

            if (keyController.d) {
                if (player.getPosition().x < sceneWidth - 32) {
                    player.move(player.getSpeed(), 0);
                }
            }

            //player shooting
            if ((keyController.left || keyController.up ||
                    keyController.right || keyController.down) && !hasFireCountStarted) {

                if (keyController.left && keyController.up && !hasShot) {
                    makeBullet(6, bulletNumber);
                    bulletNumber++;
                    hasShot = true;
                }
                if (keyController.left && !hasShot) {
                    makeBullet(1, bulletNumber);
                    bulletNumber++;
                    hasShot = true;
                }
                if (keyController.up && !hasShot) {
                    makeBullet(2, bulletNumber);
                    bulletNumber++;
                    hasShot = true;
                }
                if (keyController.right && !hasShot) {
                    makeBullet(3, bulletNumber);
                    bulletNumber++;
                    hasShot = true;
                }
                if (keyController.down && !hasShot) {
                    makeBullet(4, bulletNumber);
                    bulletNumber++;
                    hasShot = true;
                }
                hasFireCountStarted = true;
            }

            bullets.forEach((bullet) -> {
                //left
                if (bullet.getDirection() == 1) {
                    bullet.move(-bullet.getSpeed(), 0);
                }
                //up
                if (bullet.getDirection() == 2) {
                    bullet.move(0, -bullet.getSpeed());
                }
                //right
                if (bullet.getDirection() == 3) {
                    bullet.move(bullet.getSpeed(), 0);
                }
                //down
                if (bullet.getDirection() == 4) {
                    bullet.move(0, bullet.getSpeed());
                }
                //left and up
                if (bullet.getDirection() == 5) {
                    bullet.move(-bullet.getSpeed(), -bullet.getSpeed());
                }
                //left and down
                if (bullet.getDirection() == 6) {
                    bullet.move(-bullet.getSpeed(), bullet.getSpeed());
                }
                //right and up
                if (bullet.getDirection() == 7) {
                    bullet.move(bullet.getSpeed(), -bullet.getSpeed());
                }
                //right and down
                if (bullet.getDirection() == 8) {
                    bullet.move(bullet.getSpeed(), bullet.getSpeed());
                }
            });

            enemy.movement(player.getPosition().x, player.getPosition().y);

            //damage
            if (restTimer == 10) {
                if (player.getHitBox().intersects(enemy.getHitBox())) {
                    player.setHealth((float) (player.getHealth() - 0.5));
                }
            }

            //exit clause
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
            if(hasFireCountStarted){
                fireCount++;
            }
            hasShot = false;
            if (restTimer == 20) {
                restTimer = 0;
            }
            if(fireCount == fireRate){
                fireCount = 0;
                hasFireCountStarted = false;
            }
        }
    }
}