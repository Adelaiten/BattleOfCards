package com.codecool.krk;

import java.util.Random;

public class Utils{
    private Random generator;

    public Utils(){
        generator = new Random();
    }

    public int getRandomNumber(int min, int max){
        int value = generator.nextInt(max - min + 1) + min;
        return value;
    }
}