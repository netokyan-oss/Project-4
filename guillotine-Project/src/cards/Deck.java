package cards;

import java.util.Random;
import datastructures.list.LinkedList;

/**
 * This ADT represents a deck of cards.
 * @param <T> a type of card the deck contains.
 * 
 * @author Wendy-Beth Minton
 */
 public class Deck<T extends Card>
 {
   LinkedList<T> cards;

   /**
    * Construct a new empty deck.
    */
   public Deck()
   {
     cards = new LinkedList<T>();
   }

   /**
    * Adds a card to the end of the deck.
    * @param card  the card to add.
    */
   public void addCard(T card)
   {
     cards.insert(cards.getLength() + 1, card);
   }

   /**
    * Determines if the deck is empty.
    *
    * @return true if the deck is empty; otherwise, false.
    */
   public boolean isEmpty()
   {
     return cards.isEmpty();
   }

   /**
    * Shuffles the deck of cards.
    *
    * @throws UnsupportedOperationException if the deck is empty.
    */
   public void shuffle() throws UnsupportedOperationException
   {
     T tmp;
     int idx1 = 0;   // Index of the first card.
     int idx2 = 0;   // Index of the second card.
     Random rand = new Random();

     if (isEmpty())
       throw new UnsupportedOperationException("Deck is empty");


     // Shuffle the deck by randomly swapping cards.
     // Note: not a great shuffle but, will work well enough
     // for this project.
     for (int i = 0; i < 300; i++)
     {
         idx1 = 0;
         idx2 = 0;
         while (idx1 == idx2)
         {
           idx1 = rand.nextInt(cards.getLength()) + 1;
           idx2 = rand.nextInt(cards.getLength()) + 1;
         }

         // Swap the two locations.
         tmp = cards.replace(idx1, cards.getEntry(idx2));
         cards.replace(idx2, tmp);        // Ignore the return value here.
       }

   }

   /**
    * Draw the top card from the deck.
    *
    * @return the top card of the deck.
    * @throws UnsupportedOperationException if the deck is empty.
    */
   public T drawCard() throws UnsupportedOperationException
   {
     T card;

     if (cards.isEmpty())
       throw new UnsupportedOperationException("Deck is empty.");

     card = cards.getEntry(1); // Get the top card.
     cards.remove(1);

     return card;
   }
 }
