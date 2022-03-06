package Assignment2;

import java.util.Collections;

/**
 *
 * @author deepinderkaur
 */
public class Deck extends SetOfCards {

    // CONSTRUCTOR
    public Deck() {
        super.maxCards = 52;
        createCards();
    }

    //OTHERS
    private void createCards() {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                cards.add(new Card(Rank.values()[i], Suit.values()[j]));
            } // 13 Ranks and 4 Suits
        } // add all 52 cards in the deck
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card deal() {
        Card c = null;
        if (cards.size() > 0) {
            c = cards.get(0);
            cards.remove(0);
        } else {
            System.out.println("No cards left");
        }
        return c;
    }
}
