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


    private static File rootdir = new File("./src/main/resources");
    private static File boardFile = new File(rootdir, "board.txt");
    private static File moneycardsFile = new File(rootdir, "moneycards.txt");
    private static File movecardsFile = new File(rootdir, "movecards.txt");



    /**
     * Returns an ArrayList of BoardSpaces loaded from a file
     */
    public static ArrayList<BoardSpace> getBoard() {
        Scanner scan;

        ArrayList<BoardSpace> board = new ArrayList<BoardSpace>();

        MoveCard[] movecards = getMoveCards();
        MoneyCard[] moneycards = getMoneyCards();

        try {
            String line;
            String[] attr;

            scan = new Scanner(boardFile);

            while(scan.hasNextLine()){
                String type;
                int rent;
                String desc;

                line = scan.nextLine();

                //Splittar texten
                attr = line.split(";");
                int totalElements = attr.length;

                //Checkar vilket av alternativen
                //Hus ger tre alt, de andra ger length 1
                if("House".equals(attr[0]) && totalElements == 3){
                    //Skapa housespace i board
                    rent = Integer.parseInt(attr[1]);
                    desc = attr[2];
                    board.add(new HouseSpace(rent, desc));
                }
                else if("Move".equals(attr[0]) && totalElements == 1){
                    //Skapa movespace i board
                    board.add(new MoveSpace(movecards));
                }
                else if("Money".equals(attr[0]) && totalElements == 1){
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

        File file = moneycardsFile;

        try {
            String line;
            String[] attr;

            scan = new Scanner(file);

            while(scan.hasNextLine()){
                line = scan.nextLine();
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

        File file = movecardsFile;

        try {
            String line;
            String[] attr;

            scan = new Scanner(file);

            while(scan.hasNextLine()){
                line = scan.nextLine();
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
