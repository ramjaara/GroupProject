package com.company.repositories;

import com.company.objects.entities.Bullet;
import com.company.objects.entities.Enemy;
import com.company.objects.floorItems.Spawner;
import com.company.objects.floorItems.Wall;
import com.company.panels.Scene;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class sceneRepo {
    //Game object variable lists
    public static Scene scene = new Scene();
    public static List<Bullet> bullets = new ArrayList<>();
    public static List<Enemy> enemies = new ArrayList<>();
    public static List<Spawner> spawners = new ArrayList<>();
    public static List<Wall> walls = new ArrayList<>();

    //images
    public static BufferedImage bulletImage;
    public static BufferedImage enemyImage;

    public static void initialiseImages(){
        //bullet Image init
        sceneRepo.bulletImage = new BufferedImage(7, 7, BufferedImage.TYPE_INT_RGB);
        Graphics bulletGraphics = sceneRepo.bulletImage.getGraphics();
        bulletGraphics.setColor(new Color(255, 0, 0));
        bulletGraphics.fillRect(0, 0, 7, 7);

        //enemy image init
        enemyImage = new BufferedImage(32, 32, BufferedImage.TYPE_INT_RGB);
        Graphics enemyGraphics = enemyImage.getGraphics();
        enemyGraphics.setColor(new Color(0, 255, 250));
        enemyGraphics.fillRect(0, 0, 32, 32);
    }

}
