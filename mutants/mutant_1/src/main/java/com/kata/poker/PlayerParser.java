package com.kata.poker;
public class PlayerParser {
    private final com.kata.poker.HandParser handParser = new com.kata.poker.HandParser();

    com.kata.poker.Player parse(java.lang.String rawPlayer) {
        java.lang.String name = rawPlayer.split(":")[0];
        java.lang.String rawPokerHand = rawPlayer.split(": ")[1];
        com.kata.poker.Hand hand = handParser.parse(rawPokerHand);
        return new com.kata.poker.Player(name, hand);
    }
}