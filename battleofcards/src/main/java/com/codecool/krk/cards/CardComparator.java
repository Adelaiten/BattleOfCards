package com.codecool.krk.cards;

import com.codecool.krk.enums.Attributes;
import com.codecool.krk.players.Player;

import java.util.ArrayList;


public class CardComparator {

    public ArrayList<Player> compareCards(ArrayList<Player> currentTurnPlayers, Attributes attribute){
        int highestAttribute = 0;
        ArrayList<Player> winners = new ArrayList<Player>();
        for (Player player : currentTurnPlayers){
            if (player.getAttributeValue(attribute) > highestAttribute) {
                highestAttribute = player.getAttributeValue(attribute);
                winners.clear();
                winners.add(player);
            }
            else if (player.getAttributeValue(attribute) == highestAttribute) {
                winners.add(player);
            }
        }

        return winners;
    }
}