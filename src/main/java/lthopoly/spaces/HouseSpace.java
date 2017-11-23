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
            houseActions = new int[]{3, 5, 6, 7};
        }else{
            houseActions = new int[]{2, 4, 5, 6, 7};
        }
        return houseActions;
    }

    /**
     * Performs a game action available while on this space
     */
    @Override
    public void action(GameBoard board, int action) {
        if(action == 2){
            board.getCurrentPlayer().adjustMoney(-rent);
            owner = board.getCurrentPlayer();
            owned = true;
        }else if(action == 3){
            board.getCurrentPlayer().adjustMoney(-rent);
            owner.adjustMoney(rent);
        }else {
            board.doAction(action);
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
