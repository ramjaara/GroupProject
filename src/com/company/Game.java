package com.company;

import com.company.methods.bulletMethods;
import com.company.methods.enemyMethods;
import com.company.methods.playerMethods;
import com.company.objects.KeyController;
import com.company.objects.Layout;
import com.company.objects.entities.Bullet;
import com.company.objects.entities.Enemy;
import com.company.objects.entities.Player;
import com.company.objects.floorItems.Spawner;
import com.company.objects.floorItems.Wall;
import com.company.panels.Scene;
import com.company.repositories.loopRepo;
import com.company.repositories.sceneRepo;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class Game extends JFrame {

    //staying in the game class
    private Scene scene;
    private List<Bullet> bullets;
    private List<Enemy> enemies;
    private List<Spawner> spawners;
    private List<Wall> walls;
    private Layout layout;
    public KeyController keyController = new KeyController();
    ;

    public static void main() {
        Game game = new Game();
        game.gameLoop();
    }

    public void initialise() {
        this.bullets = sceneRepo.bullets;
        this.enemies = sceneRepo.enemies;
        this.spawners = sceneRepo.spawners;
        this.walls = sceneRepo.walls;
    }

    //to be assigned in layout
    protected Player player;
    //protected JLabel healthLabel;
    //protected JLabel scoreLabel;

    //assign in methods
    protected BufferedImage playerImage;
    protected BufferedImage enemyImage;

    //to be in repository
    protected int sceneWidth = 800;
    protected int sceneHeight = 800;

    public Game() {
        // makes the window
        setTitle("DONT DIE");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.scene = sceneRepo.scene;

        add(scene);
        pack();

        setSize(sceneWidth, sceneHeight);
        setVisible(true);

        init();
    }

    private void init() {
        initialise();

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

    //whole setScene method to be put in layout
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
        player = new Player("alonso", 32, 32);
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
        sceneRepo.bulletImage = new BufferedImage(7, 7, BufferedImage.TYPE_INT_RGB);
        Graphics bulletGraphics = sceneRepo.bulletImage.getGraphics();
        bulletGraphics.setColor(new Color(255, 0, 0));
        bulletGraphics.fillRect(0, 0, 7, 7);

        //test wall
        Wall testWall = new Wall(new Point(300, 300), 30, 80);
        BufferedImage wallImage = new BufferedImage(testWall.getWidth(), testWall.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics wallGraphics = wallImage.getGraphics();
        wallGraphics.setColor(new Color(0, 0, 0));
        wallGraphics.fillRect(0, 0, testWall.getWidth(), testWall.getHeight());
        testWall.setImage(wallImage);
        scene.addFloorItem(testWall);
        walls.add(testWall);
    }

    //enemyMethods
    public void kill(Enemy enemy) {
        scene.removeEntity(enemy);
        enemy.setPosition(new Point(1000, 1000));
        enemy.die();
    }

    public static void main(String[] a){
        Game game = new Game();
        game.gameLoop();
    }

    public void gameLoop() {
        long timer;
        int fireCount = 0;
        int fireRate = 30;
        int spawnRate = 0;

        while (true) {
            timer = System.currentTimeMillis();
            loopRepo.w = keyController.w;
            loopRepo.a = keyController.a;
            loopRepo.s = keyController.s;
            loopRepo.d = keyController.d;
            loopRepo.up = keyController.up;
            loopRepo.down = keyController.down;
            loopRepo.left = keyController.left;
            loopRepo.right = keyController.right;

            //healthLabel.setText("Health:\n" + player.getHealth());
            //scoreLabel.setText("Score:" + player.getScore());

            //enemySpawn (put in spawnMethods)
            if (spawnRate == 0) {
                spawners.forEach(Spawner -> {
                    if (Spawner.getAmountCreated() <= Spawner.getSpawnAmount()) {
                        Enemy enemy = (Enemy) Spawner.spawn(enemyImage);
                        enemies.add(enemy);
                        scene.addEntity(enemy);
                    }
                });
            }

            //movement
            playerMethods.playerMove(player);
            bulletMethods.bulletMove();
            enemyMethods.enemyMove(player);

            //shots can only happen after the fire count has been reset
            if (fireCount == 0) {
                playerMethods.playerShoot(player);
            }

            //enemy damage for player
            playerMethods.playerDamage(player);

            //exit clause
            /*if (player.getHealth() <= 0) {
                System.out.println("GAME OVER");
                System.exit(0);
            }*/

            scene.repaint();

            //gives 60fps
            timer = (1000 / 60) - (System.currentTimeMillis() - timer);

            if (timer > 0) {
                try {
                    Thread.sleep(timer);
                } catch (Exception e) {

                }
            }
            loopRepo.damageRestTimer++;
            spawnRate++;
            if (loopRepo.hasFireCountStarted) {
                fireCount++;
            }
            if (loopRepo.damageRestTimer == 20) {
                loopRepo.damageRestTimer = 0;
            }
            if (fireCount == fireRate) {
                fireCount = 0;
                loopRepo.hasFireCountStarted = false;
            }
            if (spawnRate == 200) {
                spawnRate = 0;
            }
        }
    }
}

