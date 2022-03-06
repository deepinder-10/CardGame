package Assignment2;

import java.util.ArrayList;

/**
 *
 * @author deepinderkaur
 */
public class SetOfCards {

    protected ArrayList<Card> cards;
    protected int maxCards;

    //CONSTRUCTORS
    public SetOfCards() {
        cards = new ArrayList<>();
    }

    // GETTERS AND SETTERS
    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        if (cards.size() < maxCards) {
            this.cards = cards;
        } else {
            System.out.println("Max size of deck is reached!");
        }
    }

    // OTHERS
    public void addCard(Card c) {
        if (cards.size() < maxCards) {
            cards.add(c);
        } else {
            System.out.println("Max size of deck is reached!");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[" + cards.get(0).getRank() + " of " + cards.get(0).getSuit());

        for (int i = 1; i < cards.size(); i++) {
            sb = sb.append(", ").append(cards.get(i).getRank()).append(" of ").append(cards.get(i).getSuit());
        }
        sb.append("]");
        return sb.toString();
    }
}
