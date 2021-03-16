package com.kata.poker;
public interface Rule {
    boolean canApply(com.kata.poker.Hand hand);

    com.kata.poker.Rank apply(com.kata.poker.Hand hand);
}