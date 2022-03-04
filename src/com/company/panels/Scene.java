package com.company.panels;

import com.company.objects.entities.Entity;
import com.company.objects.floorItems.FloorItem;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Scene extends JPanel {
    private int width;
    private int height;

    private List<Entity> entities = new ArrayList<>();
    private List<FloorItem> floorItems = new ArrayList<>();

    public void removeEntity(Entity e){entities.remove(e);}

    public Dimension getPrefferredSize(){
        return new Dimension(this.width, this.height);
    }

    public void addEntity(Entity e){entities.add(e);}
    public void addFloorItem(FloorItem f){floorItems.add(f);}

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        entities.forEach(entity -> entity.draw(g));
        floorItems.forEach(floorItem -> floorItem.draw(g));
    }
}

