package com.company;

import com.company.repositories.decisionRepo;

public class Main extends Thread {

    public static void main(String[] a) {
        Main thread = new Main();
        thread.start();
        LoginFrame frame = new LoginFrame();
    }

    public void run() {
        while (true) {
            if (decisionRepo.startGame) {
                runGame();
            }
        }
    }

    public static void runGame() {
        Game game = new Game();
        game.gameLoop();
    }
}

