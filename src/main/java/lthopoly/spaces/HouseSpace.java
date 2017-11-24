package lthopoly.spaces;


import lthopoly.GameBoard;
import lthopoly.Player;

import java.util.ArrayList;
import java.lang.Integer;

public class HouseSpace extends BoardSpace {
    int rent;
    String description;
    Boolean owned;
    Player owner;
    int[] houseActions;


    /**
     * Creates a new HouseSpace with rent and a description
     */
    public HouseSpace(int rent, String description) {
        this.rent = rent;
        this.description = description;
        owned = false;
    }

    /**
     * Returns an array of possible game actions permitted by this space
     */
    @Override
    public int[] getPossibleActions(GameBoard board) {
        if(owned){
            houseActions = new int[]{board.PAY_RENT, board.DEFAULT_VIEW, board.SHOW_BOARD, board.EXIT_GAME};
        }else{
            houseActions = new int[]{board.BUY_PROPERTY, board.END_TURN,
                    board.DEFAULT_VIEW, board.SHOW_BOARD, board.EXIT_GAME};
        }
        return houseActions;
    }

    /**
     * Performs a game action available while on this space
     */
    @Override
    public void action(GameBoard board, int action) {
        if(action == board.BUY_PROPERTY){
            board.getCurrentPlayer().adjustMoney((-1) * rent);
            owner = board.getCurrentPlayer();
            owned = true;
            System.out.println("Du har köpt detta");
        }else if (action == board.PAY_RENT){
            board.getCurrentPlayer().adjustMoney((-1) * rent);
            owner.adjustMoney(rent);
            System.out.println("Du har betalat hyra!");
        }else {
          // om man ställer sig på sin egen byggnad
        }
    }

    /**
     * Returns a string representation of this HouseSpace with the format "HouseName [Owner] (Rent)"
     */
    @Override
    public String toString() {
        return String.format("%s [%2s] (%3s)",description, owner, rent);
    }

}
