package com.codecool.krk.view;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserInterface{
    public static UserInterface SINGLETON = null;

    public UserInterface(){
        if (SINGLETON == null){
            SINGLETON = this;
        }
    }

    public void print(String message){
        System.out.print(message);
    }

    public void print(int message) {
        println(String.valueOf(message));
    }
    
    public void println(String message){
        System.out.println(message);
    }

    public void printCentered(String message, int width){
        print(center(message, width));
    }

    public void printlnCentered(String message, int width){
        println(center(message, width));
    }

    public String input(String question){
        BufferedReader keyboardInput = null;
        try {
            keyboardInput = new BufferedReader(new InputStreamReader(System.in));
            println(question);
            String answer = keyboardInput.readLine();
            return answer;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String center(String string, int width){
        int padSize = width - string.length();
        int padStart = string.length() + (padSize / 2);

        string = String.format("%" + padStart + "s", string);
        string = String.format("%-" + width + "s", string);

        return string;
    }

    public String generateLine(String fill, int width){
        StringBuilder lineBuilder = new StringBuilder();

        for (int i=0; i<width; i++){
            lineBuilder.append(fill);
        }

        return lineBuilder.toString();
    }

    public void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 

    public void asciiHello() {
        System.out.println("oooooooooo              o8     o8   o888                               o888o        oooooooo8                                oooo             ");
        System.out.println(" 888    888   ooooooo o888oo o888oo  888  ooooooooo8        ooooooo  o888oo       o888     88   ooooooo   oo oooooo     ooooo888   oooooooo8  ");
        System.out.println(" 888oooo88    ooooo888 888    888    888 888oooooo8       888     888 888         888           ooooo888   888    888 888    888  888ooooooo  ");
        System.out.println(" 888    888 888    888 888    888    888 888              888     888 888         888o     oo 888    888   888        888    888          888 ");
        System.out.println("o888ooo888   88ooo88 8o 888o   888o o888o  88oooo888        88ooo88  o888o         888oooo88   88ooo88 8o o888o         88ooo888o 88oooooo88  ");

    }
}