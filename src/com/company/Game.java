package com.company;

import com.company.objects.entities.Bullet;
import com.company.objects.entities.Enemy;
import com.company.objects.entities.Protag;
import com.company.objects.floorItems.Spawner;
import com.company.panels.Scene;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game extends JFrame {

    protected Scene scene;

    protected BufferedImage backgroundImage;

    {
        try {
            backgroundImage = ImageIO.read(new File("src/com/company/images/mapTest.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected List<Bullet> bullets = new ArrayList<>();
    protected List<Enemy> enemies = new ArrayList<>();
    protected List<Spawner> spawners = new ArrayList<>();

    protected Protag player;

    protected BufferedImage playerImage;
    protected BufferedImage enemyImage;
    protected BufferedImage bulletImage;

    protected KeyController keyController;

    protected int sceneWidth = 800;
    protected int sceneHeight = 800;

    //protected JLabel healthLabel;
    //protected JLabel scoreLabel;

    public Game() {
        // makes the window
        setTitle("DONT DIE");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        scene = new Scene(backgroundImage);

        add(scene);
        pack();

        setSize(sceneWidth, sceneHeight);
        setVisible(true);

        init();
    }

    public void setScene() {
        //enemy Spawners
        Spawner enemySpawnerB = new Spawner(new Point(400, 800), "Enemy", 10);
        spawners.add(enemySpawnerB);

        Spawner enemySpawnerL = new Spawner(new Point(0, 400), "Enemy", 10);
        spawners.add(enemySpawnerL);

        Spawner enemySpawnerT = new Spawner(new Point(400, 0), "Enemy", 10);
        spawners.add(enemySpawnerT);

        Spawner enemySpawnerR = new Spawner(new Point(800, 400), "Enemy", 10);
        spawners.add(enemySpawnerR);

        //player
        player = new Protag("alonso", 32, 32);
        playerImage = new BufferedImage(player.getWidth(), player.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics playerGraphics = playerImage.getGraphics();
        playerGraphics.setColor(new Color(255, 0, 255));
        playerGraphics.fillRect(0, 0, 32, 32);
        player.setImage(playerImage);
        player.setPosition(new Point(400, 400));

        //enemy image init
        enemyImage = new BufferedImage(32, 32, BufferedImage.TYPE_INT_RGB);
        Graphics enemyGraphics = enemyImage.getGraphics();
        enemyGraphics.setColor(new Color(0, 255, 250));
        enemyGraphics.fillRect(0, 0, 32, 32);

        //bullet Image init
        bulletImage = new BufferedImage(7, 7, BufferedImage.TYPE_INT_RGB);
        Graphics bulletGraphics = bulletImage.getGraphics();
        bulletGraphics.setColor(new Color(255, 0, 0));
        bulletGraphics.fillRect(0, 0, 7, 7);
    }

    private void init() {
        keyController = new KeyController();
        addKeyListener(keyController);

        setScene();

        /*healthLabel = new JLabel("Health:");
        healthLabel.setOpaque(true);

        scoreLabel = new JLabel("Score:");
        scoreLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
        scoreLabel.setOpaque(true);

        scene.add(healthLabel);
        scene.add(scoreLabel);*/
        scene.addEntity(player);

        scene.repaint();
    }

    public void kill(Enemy enemy) {
        scene.removeEntity(enemy);
        enemy.setPosition(new Point(1000, 1000));
        enemy.die();
    }

    public void makeBullet(int direction, int bulletNumber) {
        Bullet bullet = new Bullet("bullet" + bulletNumber,
                new Point(player.getPosition().x + 16, player.getPosition().y + 16), 3, 3,
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
        int fireRate = 30;
        int spawnRate = 0;

        while (true) {
            timer = System.currentTimeMillis();

            //healthLabel.setText("Health:\n" + player.getHealth());
            //scoreLabel.setText("Score:" + player.getScore());

            //enemySpawn
            if (spawnRate == 0) {
                spawners.forEach(Spawner -> {
                    if (Spawner.getAmountCreated() <= Spawner.getSpawnAmount()) {
                        Enemy enemy = (Enemy) Spawner.spawn(enemyImage);
                        enemies.add(enemy);
                        scene.addEntity(enemy);
                    }
                });
            }

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
                    makeBullet(5, bulletNumber);
                    bulletNumber++;
                    hasShot = true;
                }
                if (keyController.left && keyController.down && !hasShot) {
                    makeBullet(6, bulletNumber);
                    bulletNumber++;
                    hasShot = true;
                }
                if (keyController.right && keyController.up && !hasShot) {
                    makeBullet(7, bulletNumber);
                    bulletNumber++;
                    hasShot = true;
                }
                if (keyController.right && keyController.down && !hasShot) {
                    makeBullet(8, bulletNumber);
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

            //moves bullets and checks if they have shot an enemy
            bullets.forEach(Bullet -> {
                if (Bullet.isMoving()) {
                    Bullet.movement();
                    enemies.forEach(Enemy -> {
                        if (Enemy.getHitBox().intersects(Bullet.getHitBox())) {
                            player.setScore(player.getScore() + 1);
                            kill(Enemy);
                            Bullet.stop();
                        }
                    });
                }
            });

            //checks if each enemy is alive then moves them
            enemies.forEach(Enemy ->
            {
                if (Enemy.isAlive()) {
                    Enemy.movement(player.getPosition().x, player.getPosition().y);
                }
            });

            //enemy damage for player
            if (restTimer == 10) {
                enemies.forEach(Enemy -> {
                    if (player.getHitBox().intersects(Enemy.getHitBox())) {
                        player.setHealth((float) (player.getHealth() - 0.5));
                        kill(Enemy);
                    }
                });
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
            spawnRate++;
            if (hasFireCountStarted) {
                fireCount++;
            }
            hasShot = false;
            if (restTimer == 20) {
                restTimer = 0;
            }
            if (fireCount == fireRate) {
                fireCount = 0;
                hasFireCountStarted = false;
            }
            if (spawnRate == 200) {
                spawnRate = 0;
            }
        }
    }
}