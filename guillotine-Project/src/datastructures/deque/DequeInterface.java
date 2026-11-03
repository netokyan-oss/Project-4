package datastructures.deque;

/**
 * A simple deque interface.
 * @param <T> the type of data stored in the deque.
 * 
 * @author Wendy-Beth Minton
 */
 public interface DequeInterface<T>
 {
   /**
    * Returns the element at the front of the deque.
    *
    * @return the element at the front of the deque.
    * @throws EmptyQueueException if the queue is empty.
    */
   public T getFront() throws EmptyQueueException;

   /**
    * Returns the element at the back of the deque.
    *
    * @return the element at the back of the deque.
    */
    public T getBack() throws EmptyQueueException;

    /**
     * Enqueues the item {@code itm} on the front of the
     * deque.
     *
     * @param itm the item to enqueue.
     */
     public void enqueueFront(T itm);

     /**
      * Enqueues the item {@code itm} on the back of the
      * deque.
      *
      * @param itm the item to enqueue.
      */
      public void enqueueBack(T itm);


      /**
       * Dequeues an item from the front of the queue.
       *
       * @return the item at the front of the queue.
       * @throws EmptyQueueException if the queue is empty.
       */
       public T dequeueFront() throws EmptyQueueException;

       /**
        * Dequeues an item from the back of the queue.
        *
        * @return the item at the back of the queue.
        * @throws EmptyQueueException if the queue is empty.
        */
        public T dequeueBack() throws EmptyQueueException;

        /**
         * Tests if the deque is empty.
         *
         * @return true if the deque is empty; otherwise, false.
         */
         public boolean isEmpty();

         /**
          * Removes all elements from the deque.
          */
          public void clear();


          /**
           * Reverses the queue.
           */
          public void reverse();

          /**
           * Determines if the deque has been reversed.
           *
           * @return true if the deque has been reversed; otherwise, false.
           */
           public boolean isReversed();


 }
