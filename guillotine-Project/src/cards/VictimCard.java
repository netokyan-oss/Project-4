package cards;

/**
 * This class describes a basic victim.
 * @author Wendy-Beth Minton
 */
public class VictimCard extends Card
{
  private int value;    // The value of the card.

  /**
   * Creates a new card with value 0 and no name..
   */
  public VictimCard()
  {
    value = 0;
  }

  /**
   * Creates a new victim card with name {@code name} and value {@code value}.
   *
   * @param name the name of the card.
   * @param value the value of the card.
   */
  public VictimCard(String name, int value)
  {
    super(name);
    this.value = value;
  }

  /**
   * Sets the value of the card.
   *
   * @param value the value of the card.
   */
  public void setValue(int value)
  {
    this.value = value;
  }

 /**
  * Get the value of the card.
  *
  * @return the value of the card.
  */
 public int getValue()
 {
   return value;
 }

 /**
  * Returns a string form of the card.
  */
  @Override
  public String toString()
  {
    return getName() + " (" + value + ")";
  }

}
