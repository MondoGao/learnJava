package course.homework3;

import course.Helpers;

import java.util.ArrayList;
import java.util.Collections;

public class Poker {
    public static void run() {
        Card spadeA = new Card(1);
        CardGroup cards = new CardGroup();

        cards.print();

        cards.shuffle();

        Helpers.log("shuffled: ");

        cards.print();
    }
}

enum Color {
    SPADE, HEART, CLUB, DIAMOND, SPECIAL
}

class Card {
    private int number;
    private Color color;

    public Card(int number, Color color) {
        this.number = number;
        this.color = color;
    }

    public Card(int number) {
        this.number = number;
        this.color = Color.SPADE;
    }

    public String toString() {
        return this.color.name().toLowerCase() + ": " + this.number;
    }
}

class CardGroup {
    private ArrayList<Card> cards;

    public CardGroup() {
        this.cards = new ArrayList<>();
        this.init();
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    public void print() {
        for (Card c : this.cards) {
            Helpers.log(c.toString());
        }
    }

    private void init() {
        this.cards.addAll(this.generateColorGroup(Color.SPADE));
        this.cards.addAll(this.generateColorGroup(Color.HEART));
        this.cards.addAll(this.generateColorGroup(Color.CLUB));
        this.cards.addAll(this.generateColorGroup(Color.DIAMOND));
        this.cards.addAll(this.generateColorGroup(Color.SPECIAL, 2));
    }

    private ArrayList<Card> generateColorGroup(Color color, int num) {
        ArrayList<Card> cards = new ArrayList<>();

        for(int i = 1; i < num + 1; i++) {
            cards.add(new Card(i, color));
        }

        return cards;
    }

    private ArrayList<Card> generateColorGroup(Color color) {
        return this.generateColorGroup(color, 13);
    }
}
