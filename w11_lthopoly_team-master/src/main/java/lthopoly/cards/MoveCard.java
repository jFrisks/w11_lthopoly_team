package lthopoly.cards;

/**
 * Created by Tank on 4/17/2016.
 */
public class MoveCard {

    private String description;
    private int positionAdjustment;
    /**
     * Creates a new MoveCard
     */
    public MoveCard(String description, int positionAdjustment) {
        this.description = description;
        this.positionAdjustment = positionAdjustment;
    }

    /**
     * Returns the position adjustment
     */
    public int getPositionAdjustment() {
        return this.positionAdjustment;
    }

    /**
     * Returns the description of why the position is adjusted
     */
    public String getDescription() {
        return this.description;
    }


}
