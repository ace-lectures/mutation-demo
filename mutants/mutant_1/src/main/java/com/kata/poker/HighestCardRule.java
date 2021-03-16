package com.kata.poker;
public class HighestCardRule implements com.kata.poker.Rule {
    @java.lang.Override
    public boolean canApply(com.kata.poker.Hand hand) {
        return true;
    }

    @java.lang.Override
    public com.kata.poker.Rank apply(com.kata.poker.Hand hand) {
        return com.kata.poker.Rank.highCard(hand.highestCard());
    }
}