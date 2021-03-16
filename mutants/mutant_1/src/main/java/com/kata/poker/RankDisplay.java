package com.kata.poker;
public interface RankDisplay<T> {
    T display(com.kata.poker.Rank.TwoPair twoPair);

    T display(com.kata.poker.Rank.StraightFlush flush);

    T display(com.kata.poker.Rank.Flush flush);

    T display(com.kata.poker.Rank.Straight straight);

    T display(com.kata.poker.Rank.ThreeOfKind threeOfKind);

    T display(com.kata.poker.Rank.Pair pair);

    T display(com.kata.poker.Rank.HighCard highCard);
}