import cards.ActionCard;
import cards.ActionType;
import cards.VictimCard;
import datastructures.deque.LinkedDeque;

/**
 * Represents the line of victims waiting at the guillotine.
 */
public class GuillotineLine
{
    private LinkedDeque<VictimCard> deque;

    /**
     * Creates an empty guillotine line.
     */
    public GuillotineLine()
    {
        deque = new LinkedDeque<VictimCard>();
    }

    /**
     * Adds a victim to the end of the line.
     *
     * @param vic the victim to add.
     */
    public void addVictim(VictimCard vic)
    {
        deque.enqueueBack(vic);
    }

    /**
     * Applies an action, removes the appropriate victim or victims,
     * and returns the points earned.
     *
     * @param action the action card to process.
     * @return the points earned from the line.
     */
    public int processLine(ActionCard action)
    {
        int points = 0;

        if (action != null)
            processLineAction(action);

        if (deque.isEmpty())
            return points;

        int numberToRemove = 1;

        if (action != null && action.getAction() == ActionType.DOUBLE_FEATURE)
            numberToRemove = 2;

        for (int i = 0; i < numberToRemove && !deque.isEmpty(); i++)
            points += deque.dequeueFront().getValue();

        return points;
    }

    /**
     * Applies an action other than DOUBLE_FEATURE.
     *
     * @param action the action card to apply.
     */
    private void processLineAction(ActionCard action)
    {
        switch (action.getAction())
        {
            case REVERSE:
                deque.reverse();
                break;

            case ESCAPE:
                if (!deque.isEmpty())
                    deque.dequeueFront();
                break;

            case END_TO_FRONT:
                if (!deque.isEmpty())
                    deque.enqueueFront(deque.dequeueBack());
                break;

            case SWAP_LEADER:
                if (!deque.isEmpty())
                {
                    VictimCard first = deque.dequeueFront();

                    if (!deque.isEmpty())
                    {
                        VictimCard second = deque.dequeueFront();
                        deque.enqueueFront(first);
                        deque.enqueueFront(second);
                    }
                    else
                    {
                        deque.enqueueFront(first);
                    }
                }
                break;

            case DOUBLE_FEATURE:
            case UNKNOWN:
                break;
        }
    }

    /**
     * Checks whether the line is empty.
     *
     * @return true if the line is empty; otherwise false.
     */
    public boolean isEmpty()
    {
        return deque.isEmpty();
    }

    /**
     * Returns the victims in the line from front to back.
     *
     * @return a string representation of the line.
     */
    @Override
    public String toString()
    {
        return deque.toString();
    }
}
