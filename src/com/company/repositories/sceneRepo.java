package com.company.repositories;

import com.company.objects.entities.Bullet;
import com.company.objects.entities.Enemy;
import com.company.objects.floorItems.Spawner;
import com.company.objects.floorItems.Wall;

import java.util.ArrayList;
import java.util.List;

public class sceneRepo {
    public static List<Bullet> bullets = new ArrayList<>();
    public static List<Enemy> enemies = new ArrayList<>();
    public static List<Spawner> spawners = new ArrayList<>();
    public static List<Wall> walls = new ArrayList<>();
}
