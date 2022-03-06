package Assignment2;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author deepinderkaur
 */
public class Hand extends SetOfCards {

    private ArrayList<Integer> tempValue;

    // CONSTRUCTOR
    public Hand() {
        this.tempValue = new ArrayList<>();
        super.maxCards = 5;
    }

    public Hand(int max, ArrayList<Card> cards) {
        this.tempValue = new ArrayList<>();
        super.maxCards = max;
        super.cards = cards;
    }

    // OTHERS
    public String evalute() {

        if (cards.size() == 5) {

            if (checkFlush() == true) {
                return "It's a Flush!";
            } else if (isConsecutive() == true) {
                return "It's a Straight!";
            } else if (checkFlush() == true && isConsecutive() == true) {
                return "It's a Straight Flush!";
            } else if (count() == 7) {
                return "One Pair!";
            } else if (count() == 9) {
                return "Two Pair!";
            } else if (count() == 11) {
                return "Three of a Kind!";
            } else if (count() == 13) {
                return "Full House!";
            } else if (count() == 17) {
                return "Four of a Kind!";
            }
        } else {
            return "more/less cards distributed";
        }

        return "Nothing (" + highestValue() + " high)";
    } // end evaluate

    /**
     * checkFlush() method will check if all the suits are same 
     * - true and false is returned accordingly
     */
    private boolean checkFlush() {
        boolean isFlush = true;

        for (int i = 0; i < cards.size() - 1; i++) {
            if (!cards.get(i).getSuit().equals(cards.get(i + 1).getSuit())) {
                isFlush = false;
            }
        }
        return isFlush;
    } // end checkFlush

    /**
     * isConsecutive() will check if the ordinal value is consecutive 
     * - first the ordinal value of the card's rank is stored in a tempValue array 
     * - tempValue array is then sorted in ascending order 
     * - finally the tempValue array will be checked for consecutive 
     * - true and false is returned accordingly
     */
    private boolean isConsecutive() {
        boolean isStraight = true;

        for (int i = 0; i < cards.size(); i++) {
            int index = Rank.valueOf(cards.get(i).getRank().toString()).ordinal();
            tempValue.add(index);
        }

        Collections.sort(tempValue);

        for (int i = 1; i < tempValue.size(); i++) {
            if (tempValue.get(i - 1) + 1 != tempValue.get(i)) {
                isStraight = false;
            }
        } // returns false is not consecutive

        return isStraight;
    } // end isConsecutive

    /**
     * checkCount() will count how many times each element at a index appears.
     * Example: NINE NINE SEVEN NINE QUEEN will be counted as: 3 + 3 + 1 + 1 + 3;
     * which equals to 11.
     *
     * Count for all combinations: ONE PAIR: 7, TWO PAIR: 9, THREE OF A KIND: 11
     * THREE OF A KIND + ONE PAIR: 13, FOUR OF A KIND: 17
     */
    private int count() {
        int count = 0;
        for (int i = 0; i < cards.size(); i++) {

            for (int j = 0; j < cards.size(); j++) {
                if (cards.get(i).getRank().equals(cards.get(j).getRank())) {
                    ++count;
                }
            } // counting
        } // end for

        return count;
    } // end count

    /**
     * highestValue() will return the highest card in the Hand 
     * - done by getting the ordinal value of the card and comparing it 
     * - after getting the index/ordinal position of the highest card, 
     * the card at the position is returned.
     */
    private Rank highestValue() {
        int index = 0;

        for (int i = 0; i < cards.size(); i++) {
            if (index < Rank.valueOf(cards.get(i).getRank().toString()).ordinal()) {
                index = Rank.valueOf(cards.get(i).getRank().toString()).ordinal();
            }
        }
        return Rank.values()[index];
    } // end highestValue
}
