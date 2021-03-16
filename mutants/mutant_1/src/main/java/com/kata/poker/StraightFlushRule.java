package com.kata.poker;
public class StraightFlushRule implements com.kata.poker.Rule {
    @java.lang.Override
    public boolean canApply(com.kata.poker.Hand hand) {
        com.kata.poker.Rule straightRule = new com.kata.poker.StraightRule();
        com.kata.poker.Rule flushRule = new com.kata.poker.FlushRule();
        return straightRule.canApply(hand) && flushRule.canApply(hand);
    }

    @java.lang.Override
    public com.kata.poker.Rank apply(com.kata.poker.Hand hand) {
        return com.kata.poker.Rank.straightFlush(hand.highestCard());
    }
}