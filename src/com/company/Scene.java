package com.company;

import com.company.objects.entities.Entity;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Scene extends JPanel {

    private int width;
    private int height;

    private List<Entity> entities = new ArrayList<>();

    public Scene() {
        super();
        width = 100;
        height = 100;
    }

    public Dimension getPrefferredSize(){
        return new Dimension(this.width, this.height);
    }

    public void addEntity(Entity e){
        entities.add(e);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        entities.forEach((entity -> entity.draw(g)));
    }
}

