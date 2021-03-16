package com.kata.poker;
public class TwoPairRule implements com.kata.poker.Rule {
    @java.lang.Override
    public boolean canApply(com.kata.poker.Hand hand) {
        return hand.selectCoupleOfTwoCardsWithTheSameValue().isPresent();
    }

    @java.lang.Override
    public com.kata.poker.Rank apply(com.kata.poker.Hand hand) {
        java.util.List<com.kata.poker.TwoCards> twoPair = hand.selectCoupleOfTwoCardsWithTheSameValue().get();
        return com.kata.poker.Rank.twoPair(twoPair.get(0).first().value, twoPair.get(1).first().value);
    }
}