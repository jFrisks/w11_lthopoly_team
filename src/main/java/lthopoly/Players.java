package lthopoly;

import java.util.List;
import java.util.Scanner;

static public class Players {
    static public List<Player> initPlayers(){
        /*
        * SKAPA LISTA players som du returnerar i slutet
        *
        *
        *
        * */
        Scanner scan = new Scanner(System.in);

        System.out.println("Hur många spelare?");
        int totalPlayers = scan.nextInt();

        for(int i = 1; i <= totalPlayers; i++){
            System.out.println("Namn:");
            String name = scan.next();
            int money = null; //DEFUALTVÄRDE
            int pos = null; //DEFAULTVÄRDE

            players.add(new Player(name, money, pos));
        }
        return players;
    }
}
