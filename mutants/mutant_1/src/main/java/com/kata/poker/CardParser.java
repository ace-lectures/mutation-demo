package com.kata.poker;
public class CardParser {
    private static final java.util.Map<java.lang.Character, com.kata.poker.Card.Value> CHAR_TO_VALUE = new java.util.HashMap<java.lang.Character, com.kata.poker.Card.Value>() {
        {
            put('2', com.kata.poker.Card.Value.Two);
            put('3', com.kata.poker.Card.Value.Three);
            put('4', com.kata.poker.Card.Value.Four);
            put('5', com.kata.poker.Card.Value.Five);
            put('6', com.kata.poker.Card.Value.Six);
            put('7', com.kata.poker.Card.Value.Seven);
        }
    };

    private static final java.util.Map<java.lang.Character, com.kata.poker.Card.Suit> CHAR_TO_SUIT = new java.util.HashMap<java.lang.Character, com.kata.poker.Card.Suit>() {
        {
            put('C', com.kata.poker.Card.Suit.Clubs);
            put('H', com.kata.poker.Card.Suit.Hearts);
            put('D', com.kata.poker.Card.Suit.Diamonds);
        }
    };

    com.kata.poker.Card parse(java.lang.String rawCard) {
        java.lang.Character rawCardValue = rawCard.charAt(0);
        com.kata.poker.Card.Value value = com.kata.poker.CardParser.CHAR_TO_VALUE.get(rawCardValue);
        java.lang.Character rawCardSuit = rawCard.charAt(1);
        com.kata.poker.Card.Suit suit = com.kata.poker.CardParser.CHAR_TO_SUIT.get(rawCardSuit);
        return null;
    }
}