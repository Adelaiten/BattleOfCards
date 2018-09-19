package com.codecool.krk.cards;

import com.codecool.krk.races.RaceConstraints;
import com.codecool.krk.enums.Races;
import com.codecool.krk.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class CardBuilder{
    private HashMap<Races, RaceConstraints> constraintsMap;
    private RaceConstraints elfConstraints;
    private RaceConstraints humanConstraints;
    private RaceConstraints orcConstraints;
    private RaceConstraints dwarfConstraints;
    private Utils utils;

    CardBuilder(){
        constraintsMap = new HashMap<Races, RaceConstraints>();
        utils = new Utils();
        initializeRaceConstraints();
        makeConstraintsMap();
    }
        

    public void initializeRaceConstraints(){
        elfConstraints = new RaceConstraints.RaceConstraintsBuilder()
                        .minHealth(40)
                        .minDexterity(50)
                        .minIntelligence(60)
                        .minStrenght(30)
                        .build();
        humanConstraints = new RaceConstraints.RaceConstraintsBuilder()
                        .minHealth(30)
                        .minDexterity(60)
                        .minIntelligence(50)
                        .minStrenght(40)
                        .build();
        dwarfConstraints = new RaceConstraints.RaceConstraintsBuilder()
                        .minHealth(60)
                        .minDexterity(30)
                        .minIntelligence(40)
                        .minStrenght(50)
                        .build();
        orcConstraints = new RaceConstraints.RaceConstraintsBuilder()
                        .minHealth(50)
                        .minIntelligence(30)
                        .minDexterity(40)
                        .minStrenght(60)
                        .build();
    }


    private void makeConstraintsMap(){
        constraintsMap.put(Races.HUMAN, humanConstraints); //dopisac statystyki
        constraintsMap.put(Races.ELF, elfConstraints);
        constraintsMap.put(Races.DWARF, dwarfConstraints);
        constraintsMap.put(Races.ORC, orcConstraints);
    }


    public Races randomRace(){
        List<Races> keys = new ArrayList<Races>();
        keys.addAll(constraintsMap.keySet());
        return keys.get(utils.getRandomNumber(0, 3));
    }

    
    public Card makeCard(){
        Races race = randomRace();
        RaceConstraints tempConstraint = constraintsMap.get(race);
        return new Card(tempConstraint.getRandomHealth(), tempConstraint.getRandomStrenght(), tempConstraint.getRandomIntelligence(), tempConstraint.getRandomDexterity(), race);
    }
}
