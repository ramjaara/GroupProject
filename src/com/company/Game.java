package com.company;

import com.company.objects.Protag;

import javax.swing.*;

public class Game extends JFrame {

    protected Protag player = new Protag("alonso");
    public GameController controller = new GameController();

    public static void main(String[] args) {
        init();
        Game game = new Game();
        game.gameLoop();
    }

    public static void init() {
        System.out.println("initialises game");
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
