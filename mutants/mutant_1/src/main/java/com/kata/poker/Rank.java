package com.kata.poker;
public abstract class Rank implements java.lang.Comparable<com.kata.poker.Rank> {
    public static com.kata.poker.Rank highCard(com.kata.poker.Card highestCard) {
        return new com.kata.poker.Rank.HighCard(1, highestCard);
    }

    public static com.kata.poker.Rank pair(com.kata.poker.Card first, com.kata.poker.Card second, com.kata.poker.Card highestRankingKicker) {
        return new com.kata.poker.Rank.Pair(2, first, second, highestRankingKicker);
    }

    public static com.kata.poker.Rank twoPair(com.kata.poker.Card.Value firstPairValue, com.kata.poker.Card.Value secondPairValue) {
        return new com.kata.poker.Rank.TwoPair(3, firstPairValue, secondPairValue);
    }

    public static com.kata.poker.Rank threeOfKind(com.kata.poker.Card.Value value) {
        return new com.kata.poker.Rank.ThreeOfKind(4, value);
    }

    public static com.kata.poker.Rank straight(com.kata.poker.Card highestCard) {
        return new com.kata.poker.Rank.Straight(5, highestCard);
    }

    public static com.kata.poker.Rank flush(com.kata.poker.Card highestCard) {
        return new com.kata.poker.Rank.Flush(6, highestCard);
    }

    public static com.kata.poker.Rank fourOfKind(com.kata.poker.Card.Value value) {
        return new com.kata.poker.Rank.FourOfKind(7, value);
    }

    public static com.kata.poker.Rank straightFlush(com.kata.poker.Card highestCard) {
        return new com.kata.poker.Rank.StraightFlush(8, highestCard);
    }

    private final int priority;

    private final com.kata.poker.Card highestCard;

    private Rank(int priority, com.kata.poker.Card highestCard) {
        this.priority = priority;
        this.highestCard = highestCard;
    }

    public boolean higherThan(com.kata.poker.Rank other) {
        if (priority == other.priority) {
            return highestCard.higherThan(other.highestCard);
        }
        return priority > other.priority;
    }

    @java.lang.Override
    public int compareTo(com.kata.poker.Rank other) {
        return java.lang.Integer.compare(priority, other.priority);
    }

    public abstract <T> T displayUsing(com.kata.poker.RankDisplay<T> rankDisplay);

    public static class HighCard extends com.kata.poker.Rank {
        private final com.kata.poker.Card highestCard;

        private HighCard(int priority, com.kata.poker.Card highestCard) {
            super(priority, highestCard);
            this.highestCard = highestCard;
        }

        @java.lang.Override
        public <T> T displayUsing(com.kata.poker.RankDisplay<T> rankDisplay) {
            return rankDisplay.display(this);
        }

        @java.lang.Override
        public boolean equals(java.lang.Object o) {
            if (this == o)
                return true;

            if (!(o instanceof com.kata.poker.Rank.HighCard))
                return false;

            com.kata.poker.Rank.HighCard highCard = ((com.kata.poker.Rank.HighCard) (o));
            return java.util.Objects.equals(highestCard, highCard.highestCard);
        }

        @java.lang.Override
        public int hashCode() {
            return java.util.Objects.hash(highestCard);
        }

        @java.lang.Override
        public java.lang.String toString() {
            return java.lang.String.format("HighCard'{'highestCard=%s'}'", highestCard);
        }

        public com.kata.poker.Card.Value value() {
            return highestCard.value;
        }
    }

    public static class Pair extends com.kata.poker.Rank {
        private final com.kata.poker.Card first;

        private final com.kata.poker.Card second;

        private final com.kata.poker.Card highestRankingKicker;

        public Pair(int priority, com.kata.poker.Card first, com.kata.poker.Card second, com.kata.poker.Card highestRankingKicker) {
            super(priority, first);
            this.first = first;
            this.second = second;
            this.highestRankingKicker = highestRankingKicker;
        }

        @java.lang.Override
        public boolean higherThan(com.kata.poker.Rank other) {
            if (super.higherThan(other)) {
                return true;
            }
            return isPair(other) && hasHighestKickerThan(other);
        }

        private boolean isPair(com.kata.poker.Rank other) {
            return other instanceof com.kata.poker.Rank.Pair;
        }

        private boolean hasHighestKickerThan(com.kata.poker.Rank other) {
            com.kata.poker.Rank.Pair otherPair = ((com.kata.poker.Rank.Pair) (other));
            return highestRankingKicker.higherThan(otherPair.highestRankingKicker);
        }

        @java.lang.Override
        public boolean equals(java.lang.Object o) {
            if (this == o)
                return true;

            if ((o == null) || (getClass() != o.getClass()))
                return false;

            com.kata.poker.Rank.Pair pair = ((com.kata.poker.Rank.Pair) (o));
            return (java.util.Objects.equals(first, pair.first) && java.util.Objects.equals(second, pair.second)) && java.util.Objects.equals(highestRankingKicker, pair.highestRankingKicker);
        }

        @java.lang.Override
        public int hashCode() {
            return java.util.Objects.hash(first, second);
        }

        @java.lang.Override
        public java.lang.String toString() {
            return java.lang.String.format("Pair'{'first=%s, second=%s, highestRankingKicker=%s'}'", first, second, highestRankingKicker);
        }

        public com.kata.poker.Card.Value value() {
            return first.value;
        }

        @java.lang.Override
        public <T> T displayUsing(com.kata.poker.RankDisplay<T> rankDisplay) {
            return rankDisplay.display(this);
        }
    }

    public static class TwoPair extends com.kata.poker.Rank {
        private final com.kata.poker.Card.Value firstPairValue;

        private final com.kata.poker.Card.Value secondPairValue;

        public TwoPair(int priority, com.kata.poker.Card.Value firstPairValue, com.kata.poker.Card.Value secondPairValue) {
            super(priority, new com.kata.poker.Card(com.kata.poker.Card.Value.max(firstPairValue, secondPairValue), null));
            this.firstPairValue = firstPairValue;
            this.secondPairValue = secondPairValue;
        }

        @java.lang.Override
        public boolean equals(java.lang.Object o) {
            if (this == o)
                return true;

            if ((o == null) || (getClass() != o.getClass()))
                return false;

            com.kata.poker.Rank.TwoPair otherTwoPair = ((com.kata.poker.Rank.TwoPair) (o));
            return java.util.Arrays.asList(firstPairValue, secondPairValue).containsAll(java.util.Arrays.asList(otherTwoPair.firstPairValue, otherTwoPair.secondPairValue));
        }

        @java.lang.Override
        public int hashCode() {
            return java.util.Objects.hash(firstPairValue, secondPairValue);
        }

        @java.lang.Override
        public java.lang.String toString() {
            return java.lang.String.format("TwoPair{first=%s, second=%s}", firstPairValue, secondPairValue);
        }

        public com.kata.poker.Card.Value lowestRankingPairValue() {
            return com.kata.poker.Card.Value.min(firstPairValue, secondPairValue);
        }

        public com.kata.poker.Card.Value highestRankingPairValue() {
            return com.kata.poker.Card.Value.max(firstPairValue, secondPairValue);
        }

        @java.lang.Override
        public <T> T displayUsing(com.kata.poker.RankDisplay<T> rankDisplay) {
            return rankDisplay.display(this);
        }
    }

    public static class Straight extends com.kata.poker.Rank {
        private final com.kata.poker.Card highestCard;

        private Straight(int priority, com.kata.poker.Card highestCard) {
            super(priority, highestCard);
            this.highestCard = highestCard;
        }

        @java.lang.Override
        public boolean equals(java.lang.Object o) {
            if (this == o)
                return true;

            if (!(o instanceof com.kata.poker.Rank.Straight))
                return false;

            com.kata.poker.Rank.Straight straight = ((com.kata.poker.Rank.Straight) (o));
            return java.util.Objects.equals(highestCard, straight.highestCard);
        }

        @java.lang.Override
        public int hashCode() {
            return java.util.Objects.hash(highestCard);
        }

        @java.lang.Override
        public java.lang.String toString() {
            return java.lang.String.format("Straight{highestCard=%s}", highestCard);
        }

        public com.kata.poker.Card.Value highestCardValue() {
            return highestCard.value;
        }

        @java.lang.Override
        public <T> T displayUsing(com.kata.poker.RankDisplay<T> rankDisplay) {
            return rankDisplay.display(this);
        }
    }

    public static class Flush extends com.kata.poker.Rank {
        private com.kata.poker.Card highestCard;

        public Flush(int priority, com.kata.poker.Card highestCard) {
            super(priority, highestCard);
            this.highestCard = highestCard;
        }

        @java.lang.Override
        public boolean equals(java.lang.Object o) {
            if (this == o)
                return true;

            if ((o == null) || (getClass() != o.getClass()))
                return false;

            com.kata.poker.Rank.Flush flush = ((com.kata.poker.Rank.Flush) (o));
            return java.util.Objects.equals(highestCard, flush.highestCard);
        }

        @java.lang.Override
        public int hashCode() {
            return java.util.Objects.hash(highestCard);
        }

        public com.kata.poker.Card.Value highestCardValue() {
            return highestCard.value;
        }

        @java.lang.Override
        public <T> T displayUsing(com.kata.poker.RankDisplay<T> rankDisplay) {
            return rankDisplay.display(this);
        }
    }

    public static class FourOfKind extends com.kata.poker.Rank {
        private final com.kata.poker.Card.Value value;

        public FourOfKind(int priority, com.kata.poker.Card.Value value) {
            super(priority, new com.kata.poker.Card(value, com.kata.poker.Card.Suit.Clubs));
            this.value = value;
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "Four of a kind";
        }

        @java.lang.Override
        public boolean equals(java.lang.Object o) {
            if (this == o)
                return true;

            if ((o == null) || (getClass() != o.getClass()))
                return false;

            com.kata.poker.Rank.FourOfKind fourOfKind = ((com.kata.poker.Rank.FourOfKind) (o));
            return java.util.Objects.equals(value, fourOfKind.value);
        }

        @java.lang.Override
        public int hashCode() {
            return java.util.Objects.hash(value);
        }

        public com.kata.poker.Card.Value value() {
            return value;
        }

        @java.lang.Override
        public <T> T displayUsing(com.kata.poker.RankDisplay<T> rankDisplay) {
            throw new java.lang.RuntimeException("TODO");
        }
    }

    public static class StraightFlush extends com.kata.poker.Rank {
        private final com.kata.poker.Card highestCard;

        public StraightFlush(int priority, com.kata.poker.Card highestCard) {
            super(priority, highestCard);
            this.highestCard = highestCard;
        }

        @java.lang.Override
        public boolean equals(java.lang.Object o) {
            if (this == o)
                return true;

            if (!(o instanceof com.kata.poker.Rank.StraightFlush))
                return false;

            com.kata.poker.Rank.StraightFlush that = ((com.kata.poker.Rank.StraightFlush) (o));
            return java.util.Objects.equals(highestCard, that.highestCard);
        }

        @java.lang.Override
        public int hashCode() {
            return java.util.Objects.hash(highestCard);
        }

        public com.kata.poker.Card.Value highestCardValue() {
            return highestCard.value;
        }

        @java.lang.Override
        public <T> T displayUsing(com.kata.poker.RankDisplay<T> rankDisplay) {
            return rankDisplay.display(this);
        }
    }

    public static class ThreeOfKind extends com.kata.poker.Rank {
        private final com.kata.poker.Card.Value value;

        public ThreeOfKind(int priority, com.kata.poker.Card.Value value) {
            super(priority, new com.kata.poker.Card(value, com.kata.poker.Card.Suit.Clubs));
            this.value = value;
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "Three of a kind";
        }

        @java.lang.Override
        public boolean equals(java.lang.Object o) {
            if (this == o)
                return true;

            if ((o == null) || (getClass() != o.getClass()))
                return false;

            com.kata.poker.Rank.ThreeOfKind threeOfKind = ((com.kata.poker.Rank.ThreeOfKind) (o));
            return java.util.Objects.equals(value, threeOfKind.value);
        }

        @java.lang.Override
        public int hashCode() {
            return java.util.Objects.hash(value);
        }

        public com.kata.poker.Card.Value value() {
            return value;
        }

        @java.lang.Override
        public <T> T displayUsing(com.kata.poker.RankDisplay<T> rankDisplay) {
            return rankDisplay.display(this);
        }
    }
}