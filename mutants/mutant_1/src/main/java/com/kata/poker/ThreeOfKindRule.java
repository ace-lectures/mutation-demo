package com.kata.poker;
public class ThreeOfKindRule implements com.kata.poker.Rule {
    @java.lang.Override
    public boolean canApply(com.kata.poker.Hand hand) {
        return hand.hasThreeCardsWithTheSameValue();
    }

    @java.lang.Override
    public com.kata.poker.Rank apply(com.kata.poker.Hand hand) {
        com.kata.poker.ThreeCards threeCards = hand.selectThreeCardsWithTheSameValue().get();
        return com.kata.poker.Rank.threeOfKind(takeOneOf(threeCards).value);
    }

    private com.kata.poker.Card takeOneOf(com.kata.poker.ThreeCards threeCards) {
        return threeCards.first();
    }
}