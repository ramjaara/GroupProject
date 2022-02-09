package com.company;

import com.company.objects.Entity;
import com.company.objects.Protag;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Game extends JFrame {

    protected Scene scene;

    protected List<Entity> entities = new ArrayList<>();

    protected Protag player;
    protected GameController controller;

    public Game(){
        setTitle("Test Scene");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        scene = new Scene();
        add(scene);
        pack();

        setSize(1000, 1000);
        setVisible(true);

        init();
    }

    private void init(){
        controller = new GameController();
        addKeyListener(controller);
        setScene();

        scene.addEntity(player);

        scene.repaint();
    }

    public void setScene(){
        player = new Protag("alonso");
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.gameLoop();
    }

    public void gameLoop() {
        long timer;

        long update_timer = 60;

        while (true) {
            timer = System.currentTimeMillis();
            if (controller.up) {
                player.move(0, 1);
                System.out.println(player.toString());
            }
            if (controller.down) {
                player.move(0, -1);
                System.out.println(player.toString());
            }
            if (controller.left) {
                player.move(-1, 0);
                System.out.println(player.toString());
            }
            if (controller.right) {
                player.move(+1, 0);
                System.out.println(player.toString());
            }

            update_timer -= 1;

            //gives 60fps
            timer = (1000 / 60) - (System.currentTimeMillis() - timer);

            if (timer > 0) {
                try {
                    Thread.sleep(timer);
                } catch (Exception e) {

                }
            }
        }
    }
}
