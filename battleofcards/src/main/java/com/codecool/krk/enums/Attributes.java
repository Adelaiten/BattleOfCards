package com.codecool.krk.enums;

public enum Attributes{
    HEALTH("Guardian"), 
    INTELLIGENCE("Wizard"), 
    STRENGTH("Berseker"), 
    DEXTERITY("Rouge");

    private String characterClassHavingThisAttributeAsStrongest;

    Attributes(String adj){
        characterClassHavingThisAttributeAsStrongest = adj;
    }

    @Override
    public String toString() {
        return characterClassHavingThisAttributeAsStrongest;
    }
}