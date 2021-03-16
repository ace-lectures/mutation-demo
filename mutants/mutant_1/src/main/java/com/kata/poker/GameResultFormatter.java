package com.kata.poker;
public class GameResultFormatter {
    private final com.kata.poker.RankFormatter rankFormatter;

    public GameResultFormatter() {
        rankFormatter = new com.kata.poker.RankFormatter();
    }

    public java.lang.String format(com.kata.poker.GameResult result) {
        if (result instanceof com.kata.poker.GameResult.Tie) {
            return tieMessage();
        }
        return winnerMessage(((com.kata.poker.Winner) (result)));
    }

    private java.lang.String tieMessage() {
        return "Tie.";
    }

    private java.lang.String winnerMessage(com.kata.poker.Winner winner) {
        return java.lang.String.format("%s wins. - with %s", winner.playerName(), rankMessage(winner.rank()));
    }

    private java.lang.String rankMessage(com.kata.poker.Rank rank) {
        return rank.displayUsing(rankFormatter);
    }
}