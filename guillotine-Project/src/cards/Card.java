package cards;

/**
 * This class represents a simple card in the game.
 * @author Wendy-Beth Minton
 */
 public class Card
 {
   private String name;     // The name of the card.

   /**
    * Sets the name of the card to the empty string.
    */
   public Card()
   {
     name = "";
   }

   /**
    * Sets the name of the card to {@code name}.
    *
    * @param name the name of the card.
    */
   public Card(String name)
   {
     this.name = name;
   }

   /**
    * Gets the name of the card.
    * @return the name of the card.
    */
   public String getName()
   {
     return this.name;
   }

   /**
    * Sets the name of the card to {@code name}.
    *
    * @param name the name of the card.
    */
   public void setName(String name)
   {
     this.name = name;
   }

   /**
    * Converts the card to a string.
    *
    * @return a string representation of the card.
    */
    @Override
   public String toString()
   {
     return this.name;
   }
 }
