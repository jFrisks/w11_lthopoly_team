package lthopoly.parser;

import lthopoly.cards.MoneyCard;
import lthopoly.cards.MoveCard;
import lthopoly.spaces.BoardSpace;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tank on 4/17/2016.
 */
public class DocumentParser {

    /**
     * Returns an ArrayList of BoardSpaces loaded from a file
     */
    public static ArrayList<BoardSpace> getBoard() {
        List<BoardSpace> board = new ArrayList<BoardSpace>();
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader("../../board.txt"));
            String line;
            while((line = br.readLine()) != null){
                //TODO:TOLKA LINE
                //TODO:LÄGG IN I Board-arraylist

                board.add(line)
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * Returns an array of MoneyCards loaded from a file
     */
    public static MoneyCard[] getMoneyCards() {
        return null;
    }

    /**
     * Returns an array of MoveCards loaded from a file
     */
    public static MoveCard[] getMoveCards() {
        return null;
    }


}
