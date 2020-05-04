package com.java7developer.chapter13

class PlayerCharacter {

    Integer strength
    Integer dexterity
    Integer charisma
    
    PlayerCharacter() {}
    
    PlayerCharacter(Integer str, Integer dex, Integer cha) {
        strength = str
        dexterity = dex
        charisma = cha
    }
    
    static constraints = {
        strength(min:3, max:18)
        dexterity(min:3, max:18)
        charisma(min:3, max:18)
    }
}

