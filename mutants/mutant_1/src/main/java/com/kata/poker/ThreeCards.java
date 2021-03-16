package com.kata.poker;
class ThreeCards {
    private final com.kata.poker.Card first;

    private final com.kata.poker.Card second;

    private final com.kata.poker.Card third;

    public ThreeCards(com.kata.poker.Card first, com.kata.poker.Card second, com.kata.poker.Card third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public com.kata.poker.Card first() {
        return first;
    }

    public com.kata.poker.Card second() {
        return second;
    }

    public com.kata.poker.Card third() {
        return third;
    }
}