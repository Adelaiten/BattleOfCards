package com.codecool.krk.cards;

import com.codecool.krk.enums.Attributes;
import com.codecool.krk.enums.Races;
import com.codecool.krk.view.UserInterface;
import com.codecool.krk.Utils;

import java.util.HashMap;
import java.util.Map;

public class Card{
    private Map<Attributes, Integer> attributes;
    private Races race;
    private String name;
    private String[] randomAdjectives = {"Mighty", "Agile", "Famous", "Common", "Amazing", "Strange",
                                         "Tricky", "Mythical", "Charming", "Sadistic", "Epic", "Dark",
                                         "Wild", "Vivid", "Primal", "Female", "Master"};
    private final int CARD_WIDTH = 30;
    private Utils utils;

    public Card(int health, int strenght, int intelligence, int dexterity, Races race){
        attributes = new HashMap<Attributes, Integer>();
        attributes.put(Attributes.HEALTH, health);
        attributes.put(Attributes.STRENGTH, strenght);
        attributes.put(Attributes.INTELLIGENCE, intelligence);
        attributes.put(Attributes.DEXTERITY, dexterity);

        this.race = race;
        utils = new Utils();
        name = GenerateName();
    }

    public int getAttributeValue(Attributes attr){
        return attributes.get(attr).intValue();
    }

    public Races getRace(){
        return race;
    }

    private String GenerateName(){
        String name = "";
        Attributes strongestAttribute = getStrongestAttribute();

        name += getRrandomAdjective();
        name += " ";
        name += race.toString();
        name += " ";
        name += strongestAttribute.toString();

        return name;
    }

    private String getRrandomAdjective(){
        return randomAdjectives[utils.getRandomNumber(0, randomAdjectives.length-1)];
    }

    private Attributes getStrongestAttribute(){
        Attributes biggestAttribute = Attributes.HEALTH;
        int biggestAttributeValue = 0;

        for (Attributes attr : attributes.keySet()){
            int attrValue = attributes.get(attr);

            if (attrValue >= biggestAttributeValue){
                biggestAttribute = attr;
                biggestAttributeValue = attrValue;
            }
        }

        return biggestAttribute;
    }

    @Override
    public String toString() {
        StringBuilder cardStringBuilder = new StringBuilder();

        cardStringBuilder.append(" " + UserInterface.SINGLETON.generateLine("_", CARD_WIDTH-2) + " \n");
        cardStringBuilder.append("/" + UserInterface.SINGLETON.generateLine(" ", CARD_WIDTH-2) + "\\\n");
        cardStringBuilder.append("|" + UserInterface.SINGLETON.center(name, CARD_WIDTH-2) + "|\n");
        cardStringBuilder.append("|" + UserInterface.SINGLETON.center(" ", CARD_WIDTH-2) + "|\n");
        cardStringBuilder.append("|" + UserInterface.SINGLETON.center("Health: " + getAttributeValue(Attributes.HEALTH), CARD_WIDTH-2) + "|\n");
        cardStringBuilder.append("|" + UserInterface.SINGLETON.center("Strenght: " + getAttributeValue(Attributes.STRENGTH), CARD_WIDTH-2) + "|\n");
        cardStringBuilder.append("|" + UserInterface.SINGLETON.center("Intelligence: " + getAttributeValue(Attributes.INTELLIGENCE), CARD_WIDTH-2) + "|\n");
        cardStringBuilder.append("|" + UserInterface.SINGLETON.center("Dexterity: " + getAttributeValue(Attributes.DEXTERITY), CARD_WIDTH-2) + "|\n");
        cardStringBuilder.append("\\" + UserInterface.SINGLETON.generateLine("_", CARD_WIDTH-2) + "/\n");

        return cardStringBuilder.toString();
    }
}