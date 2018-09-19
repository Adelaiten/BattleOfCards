package com.codecool.krk.players;

import com.codecool.krk.cards.Card;
import com.codecool.krk.enums.Attributes;

import java.util.LinkedList;

abstract public class Player implements Comparable<Player> {


    private LinkedList<Card> hand;
    private String name;


    public void setName(String name){
        this.name = name;
    }


    public String getName(){
        return name;
    }


    public LinkedList<Card> getHand(){
        return hand;
    }


    public void setHand(LinkedList<Card> hand){
        this.hand = hand;
    }


    public int getAttributeValue(Attributes attribute){
        return hand.get(0).getAttributeValue(attribute);
    }


    public int compareTo(Player other) {
        return Integer.compare(this.getHand().size(), other.getHand().size());
    }

    
    abstract public Attributes selectCardAttribute();
}