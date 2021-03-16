package com.kata.poker;
public class Card implements java.lang.Comparable<com.kata.poker.Card> {
    public final com.kata.poker.Card.Value value;

    public final com.kata.poker.Card.Suit suit;

    public Card(com.kata.poker.Card.Value value, com.kata.poker.Card.Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    @java.lang.Override
    public int compareTo(com.kata.poker.Card otherCard) {
        return value.numericValue.compareTo(otherCard.value.numericValue);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object o) {
        if (this == o)
            return true;

        if (!(o instanceof com.kata.poker.Card))
            return false;

        com.kata.poker.Card card = ((com.kata.poker.Card) (o));
        return (value == card.value) && (suit == card.suit);
    }

    @java.lang.Override
    public int hashCode() {
        return java.util.Objects.hash(value, suit);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }

    public boolean comesBefore(com.kata.poker.Card card) {
        return value.comesBefore(card.value);
    }

    boolean higherThan(com.kata.poker.Card otherCard) {
        return value.numericValue > otherCard.value.numericValue;
    }

    public enum Value {

        Two(2),
        Three(3),
        Four(4),
        Five(5),
        Six(6),
        Seven(7),
        Queen(12),
        King(13),
        Ace(14);
        static com.kata.poker.Card.Value min(com.kata.poker.Card.Value first, com.kata.poker.Card.Value second) {
            return null;
        }

        static com.kata.poker.Card.Value max(com.kata.poker.Card.Value first, com.kata.poker.Card.Value second) {
            return null;
        }

        public final java.lang.Integer numericValue;

        Value(java.lang.Integer numericValue) {
            this.numericValue = numericValue;
        }

        public boolean comesBefore(com.kata.poker.Card.Value otherValue) {
            return (numericValue + 1) == otherValue.numericValue;
        }
    }

    public enum Suit {

        Hearts,
        Spades,
        Clubs,
        Diamonds;}
}