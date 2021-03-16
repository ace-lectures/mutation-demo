package com.kata.poker;
public class FlushRule implements com.kata.poker.Rule {
    @java.lang.Override
    public boolean canApply(com.kata.poker.Hand hand) {
        return hand.hasAllCardsWithTheSameSuit();
    }

    @java.lang.Override
    public com.kata.poker.Rank apply(com.kata.poker.Hand hand) {
        return com.kata.poker.Rank.flush(hand.highestCard());
    }
}