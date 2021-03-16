package com.kata.poker;
class RankFormatter implements com.kata.poker.RankDisplay<java.lang.String> {
    @java.lang.Override
    public java.lang.String display(com.kata.poker.Rank.TwoPair twoPair) {
        return java.lang.String.format("two pair: %ss and %ss", formatCardValue(twoPair.highestRankingPairValue()), formatCardValue(twoPair.lowestRankingPairValue()));
    }

    @java.lang.Override
    public java.lang.String display(com.kata.poker.Rank.StraightFlush flush) {
        return java.lang.String.format("straight flush: %s-high", formatCardValue(flush.highestCardValue()));
    }

    @java.lang.Override
    public java.lang.String display(com.kata.poker.Rank.Flush flush) {
        return java.lang.String.format("flush: %s-high", formatCardValue(flush.highestCardValue()));
    }

    @java.lang.Override
    public java.lang.String display(com.kata.poker.Rank.Straight straight) {
        return java.lang.String.format("straight: %s-high", formatCardValue(straight.highestCardValue()));
    }

    @java.lang.Override
    public java.lang.String display(com.kata.poker.Rank.ThreeOfKind threeOfKind) {
        return java.lang.String.format("three of a kind: %ss", formatCardValue(threeOfKind.value()));
    }

    @java.lang.Override
    public java.lang.String display(com.kata.poker.Rank.Pair pair) {
        return java.lang.String.format("pair: %ss", formatCardValue(pair.value()));
    }

    @java.lang.Override
    public java.lang.String display(com.kata.poker.Rank.HighCard highCard) {
        return java.lang.String.format("high card: %s", formatCardValue(highCard.value()));
    }

    private java.lang.String formatCardValue(com.kata.poker.Card.Value cardValue) {
        if (com.kata.poker.Card.Value.Ace.equals(cardValue)) {
            return "Ace";
        }
        if (cardValue.numericValue > 10) {
            throw new java.lang.IllegalStateException("Unexpected card value: " + cardValue);
        }
        return cardValue.numericValue.toString();
    }
}