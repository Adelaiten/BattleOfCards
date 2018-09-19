package com.codecool.krk;

import com.codecool.krk.view.UserInterface;

public class Main {
    Game game;

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
        main.startGame();
    }

    private Main() throws InterruptedException {
        game = new Game();
        new UserInterface();
    }

    public void startGame() throws InterruptedException {
        game.playGame();
    }
}
