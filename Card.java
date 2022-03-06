package Assignment2;

/**
 *
 * @author deepinderkaur
 */
public class Card {

    private Rank rank;
    private Suit suit;

    //CONSTRUCTOR 
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    //GETTERS
    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    //OTHERS
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
