package cards;

/**
 * Represents an action card.
 * @author Wendy-Beth Minton
 */
 public class ActionCard extends Card
 {
   ActionType action;     // The type of action the card supports.

   /**
    * Construct an unknown action card.
    */
   public ActionCard()
   {
     this.action = ActionType.UNKNOWN;
   }

   /**
    * Construct a new action card with {@code name} name and 
    * action type {@code action}
    * @param name the name of the card.
    * @param action the type of action the card is.
    */
   public ActionCard(String name, ActionType action)
   {
     super(name);
     this.action = action;
   }

   /**
    * Get the type of action the card supports.
    *
    * @return the action type of the card.
    */
   public ActionType getAction()
   {
     return this.action;
   }

   /**
    * Sets the cards action to {@code action}.
    *
    * @param action a valid action the card performs.
    */
   public void setAction(ActionType action)
   {
     this.action = action;
   }

   /**
    * Creates a string form of the card.
    *
    * @return the string form of the card.
    */
    @Override
    public String toString()
    {
      String res = getName();

      switch (action)
      {
        case REVERSE:
         res += "(reverse)";
        break;
        case ESCAPE:
          res += "(escape)";
        break;
        case END_TO_FRONT:
          res += "(end to front)";
        break;
        case SWAP_LEADER:
          res += "(swap leader)";
        break;
        case DOUBLE_FEATURE:
          res += "(double feature)";
        break;
        case UNKNOWN:
          res += "(UNKOWN)";
        break;
      }

      return res;
    }
 }
