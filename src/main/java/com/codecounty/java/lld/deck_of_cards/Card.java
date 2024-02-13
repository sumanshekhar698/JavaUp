package com.codecounty.java.lld.deck_of_cards;

import java.util.*;

enum Suit {SPADE, CLUB, HEART, DIAMOND}

//enum Rank {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}
enum Rank {
    ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);

    private final int value;

    private Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

class CardComparator implements Comparator<Card> {

    @Override
    public int compare(Card card1, Card card2) {
        // Compare by color first
        int colorComparison = Integer.compare(card1.getSuit().ordinal() % 2, card2.getSuit().ordinal() % 2);
        if (colorComparison != 0) {
            return colorComparison;
        }

        // Compare by suit within color
        int suitComparison = Integer.compare(card1.getSuit().ordinal(), card2.getSuit().ordinal());
        if (suitComparison != 0) {
            return suitComparison;
        }

        // Compare by rank value
        return Integer.compare(card1.getRank().getValue(), card2.getRank().getValue());
    }
}

class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new NoSuchElementException("Deck is empty");
        }
        return cards.remove(0);
    }

    public int size() {
        return cards.size();
    }
}

class Main {

    public static void main(String[] args) {
        Deck deck = new Deck();

        // Bonus: shuffle before drawing
        deck.shuffle();

        List<Card> drawnCards = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            drawnCards.add(deck.drawCard());
        }

        // Sort using Comparator.comparing and thenComparing
        Collections.sort(drawnCards,
                Comparator.comparing(Card::getSuit)
                        .thenComparing(Card::getRank));

        System.out.println("Drawn cards (sorted):");
        for (Card card : drawnCards) {
            System.out.println(card);
        }
    }
}