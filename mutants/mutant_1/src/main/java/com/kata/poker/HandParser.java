package com.kata.poker;
public class HandParser {
    private static final java.lang.String CARD_SEPARATOR = " ";

    private final com.kata.poker.CardParser cardParser = new com.kata.poker.CardParser();

    com.kata.poker.Hand parse(java.lang.String rawPokerHand) {
        return new com.kata.poker.Hand(cardsFrom(rawPokerHand));
    }

    private com.kata.poker.Card[] cardsFrom(java.lang.String rawPokerHand) {
        return java.util.Arrays.stream(rawPokerHand.split(com.kata.poker.HandParser.CARD_SEPARATOR)).map(cardParser::parse).toArray(com.kata.poker.Card[]::new);
    }
}