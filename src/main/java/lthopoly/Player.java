package lthopoly;

/**
 * Created by Tank on 4/17/2016.
 */
public class Player {

    String name;
    int money;
    int pos;

    /**
     * Creates a new player
     */
    public Player(String name, int money, int pos) {
        this.name = name;
        this.money = money;
        this.pos = pos;
    }

    /**
     * Returns this player's money
     */
    public int getMoney() {
        return this.money;
    }

    /**
     * Adjusts this player's money
     */
    public void adjustMoney(int money) {
        this.money += money;
    }

    /**
     * Returns this player's position
     */
    public int getPosition() {
        return this.pos;
    }

    /**
     * Returns a string representation of this player
     */
    @Override
    public String toString() {
        return this.name + " something more like money?";
    }

    /**
     * Sets this player's position
     */
    public void setPosition(int pos) {
        this.pos = pos;
    }
}
