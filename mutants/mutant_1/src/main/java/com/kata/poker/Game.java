package com.kata.poker;
public class Game {
    private final com.kata.poker.GameRules rules;

    public Game(com.kata.poker.GameRules rules) {
        this.rules = rules;
    }

    com.kata.poker.GameResult play(com.kata.poker.Player firstPlayer, com.kata.poker.Player secondPlayer) {
        com.kata.poker.Rank rank = rules.evaluate(firstPlayer.hand);
        com.kata.poker.Rank otherRank = rules.evaluate(secondPlayer.hand);
        if (rank.higherThan(otherRank)) {
            return new com.kata.poker.Winner(firstPlayer);
        }
        if (otherRank.higherThan(rank)) {
            return new com.kata.poker.Winner(secondPlayer);
        }
        return com.kata.poker.GameResult.tie;
    }
}