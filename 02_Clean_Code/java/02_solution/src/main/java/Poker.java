import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Poker {

    enum CardSuits {
        Clubs,
        Diamonds,
        Hearts,
        Spades
    }

    public class Card {
        private CardSuits suit;
        private int value;

        public CardSuits getSuit() {
            return suit;
        }

        public int getValue() {
            return value;
        }

        public Card(String code) {
            switch (code.substring(0,1)) {
                case "c":
                    suit = CardSuits.Clubs;
                    break;
                case "d":
                    suit = CardSuits.Diamonds;
                    break;
                case "h":
                    suit = CardSuits.Hearts;
                    break;
                case "s":
                    suit = CardSuits.Spades;
                    break;
            }
            value = Integer.parseInt(code.substring(1));
        }
    }

    public class Hand {
        private final Card[] cards;

        public Hand(String p1, String p2, String p3, String p4, String p5) {
            cards = new Card[] {
                    new Card(p1),
                    new Card(p2),
                    new Card(p3),
                    new Card(p4),
                    new Card(p5),
            };
        }

        public int getHighestCardValue() {
            return Arrays.stream(cards)
                    .mapToInt(Card::getValue)
                    .max()
                    .orElse(0);
        }
    }

    public class NicePoker {
        private Hand myHand;

        public NicePoker(String p1, String p2, String p3, String p4, String p5) {
            myHand = new Hand(p1, p2, p3, p4, p5);
        }

        public boolean doIHaveABetterHand(String p1, String p2, String p3, String p4, String p5) {
            return doIHaveABetterHand(new Hand(p1, p2, p3, p4, p5));
        }

        public boolean doIHaveABetterHand(Hand opponentHand) {
            return myHand.getHighestCardValue() > opponentHand.getHighestCardValue();
        }
    }

}
