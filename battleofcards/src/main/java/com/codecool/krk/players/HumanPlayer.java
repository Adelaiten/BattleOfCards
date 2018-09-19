package com.codecool.krk.players;

import com.codecool.krk.cards.Card;
import com.codecool.krk.enums.Attributes;
import com.codecool.krk.view.UserInterface;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.LinkedList;
import com.codecool.krk.view.UserInterface;
class HumanPlayer extends Player{
    

    public HumanPlayer(String name, LinkedList<Card> hand){
        setName(name);
        setHand(hand);
    }


    public Attributes selectCardAttribute(){
        Scanner reader = new Scanner(System.in);
        int answer = 0;
        String message;
        Attributes attribute;

        while(answer <=0 || answer > 4){ //magic number poprawic
            UserInterface.SINGLETON.println(getName() + " select attribute to fight with\n" + "(1) Health\n" + "(2) Strength\n" + "(3) Intelligence\n" + "(4) Dexterity");
            try{
                UserInterface.SINGLETON.print("Enter: ");
                answer = (int)reader.nextInt();
            }catch(InputMismatchException e){
                reader = new Scanner(System.in);
                UserInterface.SINGLETON.println("Choose number!");
            }
        }
        System.out.println(answer);

        switch(answer){
            case 1:
                attribute = Attributes.HEALTH;
            case 2:
                attribute = Attributes.STRENGTH;
            case 3:
                attribute = Attributes.INTELLIGENCE;
            case 4:
                attribute = Attributes.DEXTERITY;
            default:
                message = "";
                attribute = Attributes.DEXTERITY;
        }

        UserInterface.SINGLETON.println("You selected " + attribute.name().toLowerCase()); 
        return attribute;
    }
}