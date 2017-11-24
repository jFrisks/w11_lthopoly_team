package lthopoly.cards;

/**
 * Created by Tank on 4/17/2016.
 */
public class MoneyCard {

    private String description;
    private int money;

    /**
     * Creates a new MoneyCard
     */
    public MoneyCard(String description, int money) {
        this.description = description;
        this.money = money;
    }

    /**
     * Returns this card's money adjustment value
     */
    public int getMoney() {
        return this.money;
    }

    /**
     * Returns the description of why the money is adjusted
     */
    public String getDescription() {
        return this.description;
    }
}
