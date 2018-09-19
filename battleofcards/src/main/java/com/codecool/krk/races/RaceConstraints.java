package com.codecool.krk.races;

import com.codecool.krk.Utils;

public class RaceConstraints{
    private final int minHealth;
    private final int maxHealth;
    private final int minStrenght;
    private final int maxStrenght;
    private final int minIntelligence;
    private final int maxIntelligence;
    private final int minDexterity;
    private final int maxDexterity;
    private Utils utils;

    private RaceConstraints(RaceConstraintsBuilder builder){
        this.minHealth = builder.minHealth;
        this.maxHealth = builder.maxHealth;
        this.minStrenght = builder.minStrenght;
        this.maxStrenght = builder.maxStrenght;
        this.minIntelligence = builder.minIntelligence;
        this.maxIntelligence = builder.maxIntelligence;
        this.minDexterity = builder.minDexterity;
        this.maxDexterity = builder.maxDexterity;
        utils = new Utils();
    }

    public int getRandomHealth(){
        return utils.getRandomNumber(minHealth, maxHealth);
    }

    public int getRandomStrenght(){
        return utils.getRandomNumber(minStrenght, maxStrenght);
    }

    public int getRandomIntelligence(){
        return utils.getRandomNumber(minIntelligence, maxIntelligence);
    }

    public int getRandomDexterity(){
        return utils.getRandomNumber(minDexterity, maxDexterity);
    }

    public static class RaceConstraintsBuilder{
        public int minHealth;
        public int maxHealth;
        private int minStrenght;
        private int maxStrenght;
        private int minIntelligence;
        private int maxIntelligence;
        private int minDexterity;
        private int maxDexterity;

        public RaceConstraintsBuilder(){
            minHealth = 0;
            maxHealth = 100;
            minStrenght = 0;
            maxStrenght = 100;
            minIntelligence = 0;
            maxIntelligence = 100;
            minDexterity = 0;
            maxDexterity = 100;
        }

        public RaceConstraintsBuilder minHealth(int minHealth){
            this.minHealth = minHealth;
            return this;
        }

        public RaceConstraintsBuilder maxHealth(int maxHealth){
            this.maxHealth = maxHealth;
            return this;
        }

        public RaceConstraintsBuilder minStrenght(int minStrenght){
            this.minStrenght = minStrenght;
            return this;
        }

        public RaceConstraintsBuilder maxStrenght(int maxStrenght){
            this.maxStrenght = maxStrenght;
            return this;
        }

        public RaceConstraintsBuilder minIntelligence(int minIntelligence){
            this.minIntelligence = minIntelligence;
            return this;
        }

        public RaceConstraintsBuilder maxIntelligence(int maxIntelligence){
            this.maxIntelligence = maxIntelligence;
            return this;
        }

        public RaceConstraintsBuilder minDexterity(int minDexterity){
            this.minDexterity = minDexterity;
            return this;
        }

        public RaceConstraintsBuilder maxDexterity(int maxDexterity){
            this.maxDexterity = maxDexterity;
            return this;
        }

        public RaceConstraints build(){
            return new RaceConstraints(this);
        }
    }
}