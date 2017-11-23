package lthopoly.spaces;

import lthopoly.GameBoard;
import lthopoly.cards.MoneyCard;
import java.util.concurrent.ThreadLocalRandom;

public class MoneySpace extends BoardSpace {
        MoneyCard[] cards;
        MoneyCard card;
    /**
     * Creates a new MoneySpace. When landing on this space a card from the card array will be drawn
     */
    public MoneySpace(MoneyCard[] cards) {
        this.cards = cards;
    }

    /**
     * Returns an array of possible game actions permitted by this space
     */
    @Override
    public int[] getPossibleActions(GameBoard board) {
        int[] houseActions = {1, 5, 6, 7};
        return houseActions;
    }

    /**
     * Performs a game action available while on this space
     */
    public void action(GameBoard board, int action) {
        if (action == 1){
            card = cards[ThreadLocalRandom.current().nextInt(0, cards.length)];
            board.getCurrentPlayer().adjustMoney(card.getMoney());
        }else{
            board.doAction(action);
        }
    }

    /**
     * Returns a string representation of this MoneySpace
     */
    @Override
    public String toString() {
        return card.getDescription();
    }
}
