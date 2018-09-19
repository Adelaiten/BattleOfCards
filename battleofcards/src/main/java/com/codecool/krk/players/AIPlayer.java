package com.codecool.krk.players;
import java.util.List;
import java.util.LinkedList;
import com.codecool.krk.enums.Attributes;
import com.codecool.krk.view.UserInterface;
import com.codecool.krk.cards.Card;

class AIPlayer extends Player{
    
    
    public AIPlayer(String name, LinkedList<Card> hand){
        setName(name);
        setHand(hand);
    }


    public Attributes selectCardAttribute(){
        int highestValue = 0;
        Attributes highestAttribute = null;

        for(Attributes attribute: Attributes.values()){
            int tempAttributeValue = getHand().getFirst().getAttributeValue(attribute);

            if(highestValue < tempAttributeValue){
                highestValue = tempAttributeValue;
                highestAttribute = attribute;
            }
        }

        UserInterface.SINGLETON.println(getName() + " selected: " + highestAttribute.name().toLowerCase());
        
        return highestAttribute;
    }
}