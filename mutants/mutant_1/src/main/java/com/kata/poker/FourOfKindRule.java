package com.kata.poker;
public class FourOfKindRule implements com.kata.poker.Rule {
    @java.lang.Override
    public boolean canApply(com.kata.poker.Hand hand) {
        java.util.Optional<java.util.List<com.kata.poker.TwoCards>> twoCards = hand.selectCoupleOfTwoCardsWithTheSameValue();
        if (twoCards.isEmpty())
            return false;

        return twoCards.get().get(0).first().value == twoCards.get().get(1).first().value;
    }

    @java.lang.Override
    public com.kata.poker.Rank apply(com.kata.poker.Hand hand) {
        java.util.List<com.kata.poker.TwoCards> twoPair = hand.selectCoupleOfTwoCardsWithTheSameValue().get();
        return com.kata.poker.Rank.fourOfKind(twoPair.get(0).first().value);
    }
}