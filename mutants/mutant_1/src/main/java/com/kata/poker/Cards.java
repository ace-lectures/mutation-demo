package com.kata.poker;
import java.util.*;
public class Cards {
    private final java.util.List<com.kata.poker.Card> cards;

    public Cards(java.util.List<com.kata.poker.Card> cards) {
        this.cards = cards;
    }

    public java.util.Set<com.kata.poker.Card.Suit> allSuits() {
        return cards.stream().map(( c) -> c.suit).collect(java.util.stream.Collectors.toSet());
    }

    public java.util.Optional<java.util.List<com.kata.poker.Card>> selectCardsWithTheSameValue(int groupSize) {
        return groupWithAtLeastSize(groupSize).map(( cards) -> cards.subList(0, groupSize));
    }

    private java.util.Optional<java.util.List<com.kata.poker.Card>> groupWithAtLeastSize(int groupSize) {
        return groupByValue().stream().filter(( cards) -> cards.size() >= groupSize).findFirst();
    }

    private java.util.Collection<java.util.List<com.kata.poker.Card>> groupByValue() {
        return cards.stream().collect(java.util.stream.Collectors.groupingBy(( c) -> c.value)).values();
    }

    com.kata.poker.Card highestCard() {
        return cards.stream().max(com.kata.poker.Card::compareTo).get();
    }

    com.kata.poker.Cards allExcept(com.kata.poker.Card... cardsToExclude) {
        java.util.List<com.kata.poker.Card> remainingCards = cards.stream().filter(( card) -> !java.util.Arrays.asList(cardsToExclude).contains(card)).collect(java.util.stream.Collectors.toList());
        return new com.kata.poker.Cards(remainingCards);
    }

    boolean hasAllConsecutiveValues() {
        java.util.List<com.kata.poker.Card> sortedList = new java.util.ArrayList<>(cards);
        sortedList.sort(com.kata.poker.Card::compareTo);
        for (int cardIndex = 1; cardIndex < sortedList.size(); cardIndex++) {
            if (!sortedList.get(cardIndex - 1).comesBefore(sortedList.get(cardIndex))) {
                return false;
            }
        }
        return true;
    }

    public int size() {
        return cards.size();
    }

    @java.lang.Override
    public boolean equals(java.lang.Object o) {
        if (this == o)
            return true;

        if ((o == null) || (getClass() != o.getClass()))
            return false;

        com.kata.poker.Cards otherCards = ((com.kata.poker.Cards) (o));
        return java.util.Objects.equals(cards, otherCards.cards);
    }

    @java.lang.Override
    public int hashCode() {
        return java.util.Objects.hash(cards);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return cards.toString();
    }
}