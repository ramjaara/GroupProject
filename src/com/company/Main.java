package com.company;

public class Main {
    public static void main(String[] a) {
        boolean gameRunning = false;
        LoginFrame frame = new LoginFrame();
        while(true){
            if(frame.CanGameRun()){
                gameRunning = true;
                break;
            }
        }
        if(gameRunning){
            Game game = new Game();
            game.gameLoop();
        }
    }
}

