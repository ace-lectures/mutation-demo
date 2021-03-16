package com.kata.poker;
public class GameRunner {
    public static final java.lang.String PLAYER_SEPARATOR = "  ";

    private final com.kata.poker.PlayerParser playerParser;

    private final com.kata.poker.Game game;

    private final com.kata.poker.GameResultFormatter gameResultFormatter;

    public GameRunner() {
        playerParser = new com.kata.poker.PlayerParser();
        game = new com.kata.poker.Game(new com.kata.poker.GameRules());
        gameResultFormatter = new com.kata.poker.GameResultFormatter();
    }

    public java.lang.String run(java.lang.String rawGameInput) {
        com.kata.poker.GameResult gameResult = game.play(firstPlayer(rawGameInput), secondPlayer(rawGameInput));
        return gameResultFormatter.format(gameResult);
    }

    private com.kata.poker.Player firstPlayer(java.lang.String rawGameInput) {
        java.lang.String rawFirstPlayer = rawGameInput.split(com.kata.poker.GameRunner.PLAYER_SEPARATOR)[0];
        return playerParser.parse(rawFirstPlayer);
    }

    private com.kata.poker.Player secondPlayer(java.lang.String rawGameInput) {
        java.lang.String rawSecondPlayer = rawGameInput.split(com.kata.poker.GameRunner.PLAYER_SEPARATOR)[1];
        return playerParser.parse(rawSecondPlayer);
    }
}