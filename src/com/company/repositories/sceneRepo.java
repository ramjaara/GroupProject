package com.company.repositories;

import com.company.objects.entities.Bullet;
import com.company.objects.entities.Enemy;
import com.company.objects.floorItems.Spawner;
import com.company.objects.floorItems.Wall;
import com.company.panels.Scene;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class sceneRepo {
    //Game objact variables
    public static Scene scene = new Scene();
    public static List<Bullet> bullets = new ArrayList<>();
    public static List<Enemy> enemies = new ArrayList<>();
    public static List<Spawner> spawners = new ArrayList<>();
    public static List<Wall> walls = new ArrayList<>();

    //images
    public static BufferedImage bulletImage;

}
