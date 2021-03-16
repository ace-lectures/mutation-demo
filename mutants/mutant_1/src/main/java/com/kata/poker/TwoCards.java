package com.kata.poker;
public class TwoCards {
    private final com.kata.poker.Card first;

    private final com.kata.poker.Card second;

    public TwoCards(com.kata.poker.Card first, com.kata.poker.Card second) {
        this.first = first;
        this.second = second;
    }

    public com.kata.poker.Card first() {
        return first;
    }

    public com.kata.poker.Card second() {
        return second;
    }

    @java.lang.Override
    public boolean equals(java.lang.Object o) {
        if (this == o)
            return true;

        if ((o == null) || (getClass() != o.getClass()))
            return false;

        com.kata.poker.TwoCards twoCards = ((com.kata.poker.TwoCards) (o));
        return java.util.Objects.equals(first, twoCards.first) && java.util.Objects.equals(second, twoCards.second);
    }

    @java.lang.Override
    public int hashCode() {
        return java.util.Objects.hash(first, second);
    }
}