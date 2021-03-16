package com.kata.poker;
public class Winner implements com.kata.poker.GameResult {
    private final com.kata.poker.Player player;

    public Winner(com.kata.poker.Player player) {
        this.player = player;
    }

    public com.kata.poker.Rank rank() {
        return new com.kata.poker.GameRules().evaluate(player.hand);
    }

    public java.lang.String playerName() {
        return player.name;
    }

    @java.lang.Override
    public boolean equals(java.lang.Object o) {
        if (this == o)
            return true;

        if ((o == null) || (getClass() != o.getClass()))
            return false;

        com.kata.poker.Winner that = ((com.kata.poker.Winner) (o));
        return java.util.Objects.equals(player, that.player);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return (((playerName() + " with ") + rank()) + " ") + player.hand;
    }
}