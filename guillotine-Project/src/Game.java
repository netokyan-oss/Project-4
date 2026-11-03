import cards.Deck;
import cards.VictimCard;
import cards.ActionCard;
import cards.ActionType;
import java.util.Random;
import java.util.Scanner;

/**
 * This class runs the Guillotine Game with the computer.
 * @author Wendy-Beth Minton
 */
 public class Game
 {
   /**
    * Build the victim deck, shuffle it, and return it to the caller.
    *
    * @return the shuffled victim deck.
    */
   public static Deck<VictimCard> buildVictimDeck()
   {
     VictimCard card;
     Deck<VictimCard> victimDeck = new Deck<VictimCard>();

     String[] victimNames = {"Hero of the People", "Martyr", "Guard",
       "Mayor", "Tax Collector", "King Louis XVI", "Marie Antoinette", "Baron",
       "Count", "Countess", "Lady", "Lord"};
     int[] victimValues = new int[] {-3, -1, 5, 3, 2, 5, 5, 3, 2, 3, 2, 2};

     for (int i = 0; i < 12; i++)
        victimDeck.addCard(new VictimCard(victimNames[i], victimValues[i]));

     victimDeck.shuffle();
     return victimDeck;
   }

   /**
    * Build the action deck, shuffles it, and return it to the
    * caller.
    *
    * @return the shuffled action deck.
    */
   public static Deck<ActionCard> buildActionDeck()
   {
     Deck<ActionCard> actionDeck = new Deck<ActionCard>();
     ActionCard card = new ActionCard();

     String[] actionNames = {"Forward, March!", "The Long Walk",
          "A Double Feature", "Not today!", "After you."};
     ActionType[] actions = new ActionType[] {ActionType.END_TO_FRONT,
         ActionType.REVERSE, ActionType.DOUBLE_FEATURE, ActionType.ESCAPE,
         ActionType.SWAP_LEADER};
     int[] distribution = new int[] {2, 3, 2, 4, 3};

     for (int i = 0; i < actionNames.length; i++)
     {
       // Add the correct number of copies of each card.
         for (int j = 0; j < distribution[i]; j++)
            actionDeck.addCard(new ActionCard(actionNames[i], actions[i]));
     }

     actionDeck.shuffle();
     return actionDeck;
   }

   /**
    * Run the game between the computer and human.
    *
    * @parm victimDeck a non-empty deck of victim cards.
    * @param actionDeck a non-empty deck of action cards.
    * @return true is returned if the human one; otherwise false.
    */
   public static boolean playGame(Deck<VictimCard> victimDeck,
      Deck<ActionCard> actionDeck)
   {
     int humanScore = 0;
     int compScore = 0;
     int turnCounter = 0;
     char choice = 'N';
     ActionCard currCard = null;
     ActionCard skipAction = new ActionCard("None", ActionType.UNKNOWN);
     GuillotineLine guillotineLine = new GuillotineLine();
     Random rand = new Random();
     Scanner scan = new Scanner(System.in);

     // Build up the guillotine line by drawing five cards.
     for (int i = 0; i < 5; i++)
       guillotineLine.addVictim(victimDeck.drawCard());

     // Infinite loop to play the game.
     while (true)
     {
         // Display the queue.
         System.out.println(guillotineLine);

         // Print a blank line for readability[0]
         System.out.println();

         // If possible draw and action card.
         try
         {
           currCard = actionDeck.drawCard();
         }
         catch(UnsupportedOperationException ex)
         {
           
            System.out.println("Action deck is empty. No new actions allowed.");
         }

         if (turnCounter % 2 == 0)     // Player turn.
         {
             // Only give the human a choice if we have an action card
             // left.
             if (currCard.getAction() != ActionType.UNKNOWN)
             {
               System.out.println("Action Card: " + currCard);

               // User has the option to play the card.
               do
               {
                System.out.print("Do you wish to play the action? (Y/N): ");
                choice = scan.nextLine().charAt(0);
                choice = Character.toUpperCase(choice);
              } while (choice != 'N' && choice != 'Y');
             }

           if (currCard.getAction() != ActionType.UNKNOWN && choice == 'Y')
             humanScore += guillotineLine.processLine(currCard);
           else
             humanScore += guillotineLine.processLine(skipAction);
         }
         else                          // Computer's turn.
         {
           int skip = rand.nextInt() % 2;

           // Computer flips a coin to play the action.
           if (currCard.getAction() == ActionType.UNKNOWN || skip == 0)
           {
             System.out.println("Computer is not playing an action.");
             compScore += guillotineLine.processLine(skipAction);
           }
           else
           {
             System.out.println("Computer is playing: " + currCard);
             compScore += guillotineLine.processLine(currCard);
           }
         }

         // Display the scores.
         System.out.println();
         System.out.println("   Human Score: " + humanScore);
         System.out.println("Computer Score: " + compScore);
         System.out.println();

         // Check if we are out of cards in the line.
         if (guillotineLine.isEmpty())
           return (humanScore >= compScore);

         // Add a new victim if the deck is not empty. If the
         // deck is empty, just let the line clear out.
         if (!victimDeck.isEmpty())
             guillotineLine.addVictim(victimDeck.drawCard());

         turnCounter++;        // Update the turn counter
     }
   }

   public static void main(String[] args)
   {
     Deck<VictimCard> vics;
     Deck<ActionCard> actions;

     // Game logic.
     vics = buildVictimDeck();
     actions = buildActionDeck();

     // Play the game and output the name of the winner.
     if (playGame(vics, actions))
       System.out.println("Congratulations! You won.");
     else
       System.out.println("Sorry! The computer won.");
   }

 }
