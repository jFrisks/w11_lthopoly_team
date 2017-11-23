package lthopoly.parser;

import lthopoly.cards.MoneyCard;
import lthopoly.cards.MoveCard;
import lthopoly.spaces.BoardSpace;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Tank on 4/17/2016.
 */
public class DocumentParser {

    /**
     * Returns an ArrayList of BoardSpaces loaded from a file
     */
    public static ArrayList<BoardSpace> getBoard() {
        Scanner scan;
        ArrayList<BoardSpace> board = new ArrayList<BoardSpace>();

        File file = new File("../../../resources/board.txt");

        try {
            String line;
            String[] attr;

            scan = new Scanner(file);

            while((line = scan.nextLine()) != null){
                //Splittar texten
                attr = line.split(";");

                //Assignar lämliga namn
                String desc = attr[0];
                int money = Integer.parseInt(attr[1]);

                //Lägg in attributes
                board.add();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return board;
    }


    /**
     * Returns an array of MoneyCards loaded from a file
     */
    public static MoneyCard[] getMoneyCards() {
        Scanner scan;

        List<MoneyCard> moneycards = new ArrayList<MoneyCard>();

        File file = new File("../../../resources/moneycard.txt");

        try {
            String line;
            String[] attr;

            scan = new Scanner(file);

            while((line = scan.nextLine()) != null){
                //Splittar texten
                attr = line.split(";");

                //Assignar lämliga namn
                String desc = attr[0];
                int money = Integer.parseInt(attr[1]);

                //Lägg in attributes
                moneycards.add(new MoneyCard(desc, money));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return moneycards.toArray(new MoneyCard[]{});
    }

    /**
     * Returns an array of MoveCards loaded from a file
     */
    public static MoveCard[] getMoveCards() {
        return null;
    }


}
