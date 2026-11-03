package datastructures;

/**
 * A generic DoubleNode for chaining.
 *
 * @param <T> the object that is stored in the node.
 * @author Wendy-Beth Minton
 */
 public class DoubleNode<T>
 {
   private T item;          // The DoubleNodes data.
   private DoubleNode<T> next;    // Reference to next node
   private DoubleNode<T> prev;    // Reference to previous node.

   /**
    * The default constructor. It sets the next reference to null.
    */
    public DoubleNode()
    {
      this.next = null;
    }

    /**
     * This is the overloaded constructor that sets the item
     * to itm and the next and prev reference to null.
     *
     * @param itm the item stored in the DoubleNode.
     */
     public DoubleNode(T itm)
     {
        this.item = itm;
        this.next = null;
        this.prev = null;
     }

     /**
      * This is the overloaded constructor that sets the item to itm and the
      * next reference to nxt.
      *
      * @param itm the item to be stored in the node.
      * @param next the reference to the next node in the chain.
      * @param prev the reference to the prev node in the chain.
      */
     public DoubleNode(T itm, DoubleNode<T> next, DoubleNode<T> prev)
     {
        this.item = itm;
        this.next = next;
        this.prev = prev;
     }

     /**
      * Set the item field of the node to item.
      *
      * @param item the item to store in the node.
      */
     public void setItem(T item)
     {
       this.item = item;
     }

     /**
      * Get the value stored in the item field of the node.
      *
      * @return the item stored in the node.
      */
     public T getItem()
     {
       return item;
     }

     /**
      * Set the value of the next reference.
      *
      * @param next the reference to the next node in the chain.
      */
     public void setNext(DoubleNode<T> next)
     {
       this.next = next;
     }

     /**
      * Return the reference to the next node in the chain.
      *
      * @return the reference to the next node in the chain.
      */
     public DoubleNode<T> getNext()
     {
       return this.next;
     }

     /**
      * Set the value of the previous reference.
      *
      * @param prev the reference to the previous node in the chain.
      */
     public void setPrev(DoubleNode<T> prev)
     {
       this.prev = prev;
     }

     /**
      * Return the reference to the previous node in the chain.
      *
      * @return the reference to the previous node in the chain.
      */
     public DoubleNode<T> getPrev()
     {
       return this.prev;
     }
 }
