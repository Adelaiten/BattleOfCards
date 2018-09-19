package com.codecool.krk.enums;

public enum Races{
    HUMAN, ELF, DWARF, ORC;

    @Override
    public String toString() {
        String lowercaseName = this.name().toLowerCase();
        String titlecaseName = lowercaseName.substring(0, 1).toUpperCase() + lowercaseName.substring(1);
        return titlecaseName;
    }
}