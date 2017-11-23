package lthopoly.parser;

import lthopoly.cards.MoneyCard;
import lthopoly.cards.MoveCard;
import lthopoly.spaces.BoardSpace;
import lthopoly.spaces.HouseSpace;
import lthopoly.spaces.MoneySpace;
import lthopoly.spaces.MoveSpace;

import java.io.*;
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
        MoveCard[] movecards = getMoveCards();
        MoneyCard[] moneycards = getMoneyCards();


        File file = new File("../../../resources/board.txt");

        try {
            String line;
            String[] attr;

            scan = new Scanner(file);

            while((line = scan.nextLine()) != null){
                String type;
                int rent;
                String desc;

                //Splittar texten
                attr = line.split(";");
                int totalElements = attr.length;

                //Checkar vilket av alternativen
                //Hus ger tre alt, de andra ger length 1
                if(attr[0] == "House" && totalElements == 3){
                    //Skapa housespace i board
                    rent = Integer.parseInt(attr[1]);
                    desc = attr[2];
                    board.add(new HouseSpace(rent, desc));
                }
                else if(attr[0] == "Move" && totalElements == 1){
                    //Skapa movespace i board
                    board.add(new MoveSpace(movecards));
                }
                else if(attr[0] == "Money" && totalElements == 1){
                    //skapa moneyspace
                    board.add(new MoneySpace(moneycards));
                }
                else{
                    System.out.println("Något gick jävligt fel med persern");
                }
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

        File file = new File("../../../resources/moneycards.txt");

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
        Scanner scan;

        List<MoveCard> movecards = new ArrayList<MoveCard>();

        File file = new File("../../../resources/movecards.txt");

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
                movecards.add(new MoveCard(desc, money));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return movecards.toArray(new MoveCard[]{});
    }
}
