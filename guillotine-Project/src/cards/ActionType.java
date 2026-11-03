package cards;

/**
 * Represents the actions supported by the game.
 * @author Wendy-Beth Minton
 */
public enum ActionType
{
    /**
     * Reverse the line.
     */
    REVERSE,

    /**
     * Escape line with your head.
     */
    ESCAPE,

    /**
     * Move the victim at the end of the line
     * to the front.
     */
    END_TO_FRONT,

    /**
     * Swap the front two cards.
     */
    SWAP_LEADER,

    /**
     * Take the first two cards.
     */
    DOUBLE_FEATURE,

    /**
     * No action.
     */
    UNKNOWN
}
