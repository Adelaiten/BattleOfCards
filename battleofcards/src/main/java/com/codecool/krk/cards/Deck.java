package com.codecool.krk.cards;

import com.codecool.krk.cards.Card;
import com.codecool.krk.cards.CardBuilder;

import java.util.LinkedList;

public class Deck{
    private LinkedList<Card> cardsList;
    private final int CARDS_PER_PLAYER = 10;
    private CardBuilder cardBuilder;
    
    public LinkedList<Card> dealCardsForPlayers(){
            
        cardBuilder = new CardBuilder();
        LinkedList<Card> cardsList = new LinkedList<Card>();
        for(int j=0; j < CARDS_PER_PLAYER; j++){
            cardsList.add(cardBuilder.makeCard());
        }

        return cardsList; 
    }

    public LinkedList<Card> getCardList() {
        return cardsList;
    }
}
