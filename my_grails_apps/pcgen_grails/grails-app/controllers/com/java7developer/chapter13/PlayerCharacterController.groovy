package com.java7developer.chapter13

class PlayerCharacterController {

    List playerCharacters
    
    def list = {
        playerCharacters = PlayerCharacter.list()
    }
}

