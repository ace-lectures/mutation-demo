package com.kata.poker;
public class PairRule implements com.kata.poker.Rule {
    @java.lang.Override
    public boolean canApply(com.kata.poker.Hand hand) {
        return hand.hasTwoCardsWithTheSameValue();
    }

    @java.lang.Override
    public com.kata.poker.Rank apply(com.kata.poker.Hand hand) {
        com.kata.poker.TwoCards twoCards = hand.selectTwoCardsWithTheSameValue().get();
        com.kata.poker.Cards kickers = hand.allCardsExcept(twoCards.first(), twoCards.second());
        return com.kata.poker.Rank.pair(twoCards.first(), twoCards.second(), kickers.highestCard());
    }
}