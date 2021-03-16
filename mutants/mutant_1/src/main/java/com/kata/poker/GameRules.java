package com.kata.poker;
public class GameRules {
    private final java.util.List<com.kata.poker.Rule> rules = java.util.Arrays.asList(new com.kata.poker.StraightFlushRule(), new com.kata.poker.FourOfKindRule(), new com.kata.poker.FlushRule(), new com.kata.poker.StraightRule(), new com.kata.poker.ThreeOfKindRule(), new com.kata.poker.TwoPairRule(), new com.kata.poker.PairRule(), new com.kata.poker.HighestCardRule());

    com.kata.poker.Rank evaluate(com.kata.poker.Hand hand) {
        return rules.stream().filter(( rule) -> rule.canApply(hand)).map(( rule) -> rule.apply(hand)).max(com.kata.poker.Rank::compareTo).orElse(null);
    }
}