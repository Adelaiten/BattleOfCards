package com.codecool.krk.players;

import com.codecool.krk.cards.Deck;
import com.codecool.krk.view.UserInterface;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class PreparePlayers{

    public ArrayList createPlayers(){
        UserInterface userInterface = new UserInterface();
        boolean isNum = false;
        int numOfHumans = 2;
        int numOfAI = 0;
        Scanner scanner;

        while(!isNum ||(numOfHumans+numOfAI) < 2)
        {
            scanner = new Scanner(System.in);
            try
            {
                userInterface.print("Please provide how many human players are going to play ");
                numOfHumans = scanner.nextInt();
                userInterface.print("Please provide how many AI players are going to play ");
                numOfAI = scanner.nextInt();
                isNum=true;
                if (numOfHumans+numOfAI < 0){
                    userInterface.print("Can't go with negative numbers of players :/");
                }
                if(numOfHumans+numOfAI < 2){
                    userInterface.print("Well.. we need at least 2 players...");
                }
            }
            catch (InputMismatchException exception)
            {
                System.out.println("Numbers only, please.");

            }
        }        
        
        Deck deck = new Deck();

        ArrayList<Player> listOfPlayers = new ArrayList<Player>();

        for (int i=0; i<numOfHumans; i++){
                String name = userInterface.input("What's your nickname? ");
                listOfPlayers.add(new HumanPlayer(name, deck.dealCardsForPlayers()));
        }
        for (int i=0; i<numOfAI; i++){
            String name = "bot" + Integer.toString(i);
            listOfPlayers.add(new AIPlayer(name, deck.dealCardsForPlayers()));
        }

        return listOfPlayers;
    }
}