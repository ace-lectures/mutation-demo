package com.kata.poker;
public interface GameResult {
    class Tie implements com.kata.poker.GameResult {
        private Tie() {
        }
    }

    com.kata.poker.GameResult tie = new com.kata.poker.GameResult.Tie();
}