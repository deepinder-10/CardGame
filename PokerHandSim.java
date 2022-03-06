package Assignment2;

import java.util.ArrayList;

/**
 *
 * @author deepinderkaur
 */
public class PokerHandSim {

    public static void main(String[] args) {

        Deck deck = new Deck();
        deck.shuffle();
        // deck.deal();
        
        System.out.println("Poker simulation - initial hand:\n");
        
        Hand a = new Hand(5, new ArrayList<>(deck.cards.subList(0, 5)));
        Hand b = new Hand(5, new ArrayList<>(deck.cards.subList(5, 10)));
        Hand c = new Hand(5, new ArrayList<>(deck.cards.subList(10, 15)));
        Hand d = new Hand(5, new ArrayList<>(deck.cards.subList(15, 20)));

        System.out.println("Player 1:\n" + a + "\n" + a.evalute() + "\n");
        System.out.println("Player 2:\n" + b + "\n" + b.evalute() + "\n");
        System.out.println("Player 3:\n" + c + "\n" + c.evalute() + "\n");
        System.out.println("Player 4:\n" + d + "\n" + d.evalute() + "\n");

        int remainingCards = deck.cards.size() - (a.cards.size() + b.cards.size()
                + c.cards.size() + d.cards.size());

        System.out.println("Number of cards remaining in the Deck:\n" + remainingCards);
    } // main end
} // class end
