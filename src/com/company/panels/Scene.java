package com.company.panels;

import com.company.objects.entities.Entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Scene extends JPanel {

    private int width;
    private int height;
    private BufferedImage background;

    private List<Entity> entities = new ArrayList<>();

    public Scene(BufferedImage background) {
        super();
        this.background = background;
        width = 100;
        height = 100;
    }

    public void removeEntity(Entity e){entities.remove(e);}

    public Dimension getPrefferredSize(){
        return new Dimension(this.width, this.height);
    }

    public void addEntity(Entity e){entities.add(e);}

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background, 0 , 0, this);
        entities.forEach((entity -> entity.draw(g)));
    }
}

