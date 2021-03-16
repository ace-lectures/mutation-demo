package com.kata.poker;
public class Hand {
    public class FourCardsExpectedException extends java.lang.RuntimeException {}

    private final com.kata.poker.Cards cards;

    public Hand(com.kata.poker.Card... cards) {
        if (cards.length != 4) {
            throw new com.kata.poker.Hand.FourCardsExpectedException();
        }
        this.cards = new com.kata.poker.Cards(java.util.Arrays.asList(cards));
    }

    public com.kata.poker.Card highestCard() {
        return cards.highestCard();
    }

    public boolean hasAllCardsWithConsecutiveValues() {
        return cards.hasAllConsecutiveValues();
    }

    public boolean hasAllCardsWithTheSameSuit() {
        return cards.allSuits().size() == 1;
    }

    public boolean hasTwoCardsWithTheSameValue() {
        return selectTwoCardsWithTheSameValue().isPresent();
    }

    public boolean hasThreeCardsWithTheSameValue() {
        return selectThreeCardsWithTheSameValue().isPresent();
    }

    public com.kata.poker.Cards allCardsExcept(com.kata.poker.Card... cardsToExclude) {
        return cards.allExcept(cardsToExclude);
    }

    public java.util.Optional<java.util.List<com.kata.poker.TwoCards>> selectCoupleOfTwoCardsWithTheSameValue() {
        java.util.List<com.kata.poker.TwoCards> twoPair = new java.util.ArrayList<>();
        com.kata.poker.Cards remainingCards = this.cards;
        while (remainingCards.size() >= 2) {
            if (remainingCards.selectCardsWithTheSameValue(2).isEmpty()) {
                return java.util.Optional.empty();
            }
            java.util.List<com.kata.poker.Card> pairCards = remainingCards.selectCardsWithTheSameValue(2).get();
            com.kata.poker.TwoCards twoCards = new com.kata.poker.TwoCards(pairCards.get(0), pairCards.get(1));
            twoPair.add(twoCards);
            remainingCards = remainingCards.allExcept(twoCards.first(), twoCards.second());
        } 
        return java.util.Optional.of(twoPair);
    }

    public java.util.Optional<com.kata.poker.TwoCards> selectTwoCardsWithTheSameValue() {
        return cards.selectCardsWithTheSameValue(2).map(( cards) -> new com.kata.poker.TwoCards(cards.get(0), cards.get(1)));
    }

    public java.util.Optional<com.kata.poker.ThreeCards> selectThreeCardsWithTheSameValue() {
        return cards.selectCardsWithTheSameValue(3).map(( cards) -> new com.kata.poker.ThreeCards(cards.get(0), cards.get(1), cards.get(2)));
    }

    @java.lang.Override
    public java.lang.String toString() {
        return cards.toString();
    }
}