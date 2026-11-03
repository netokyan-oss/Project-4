package datastructures.deque;

import datastructures.DoubleNode;

/**
 * A double-ended queue implemented with a doubly linked chain.
 *
 * @param <T> the type of item stored in the deque.
 */
public class LinkedDeque<T> implements DequeInterface<T>
{
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private boolean reversed;

    /**
     * Creates an empty deque.
     */
    public LinkedDeque()
    {
        head = null;
        tail = null;
        reversed = false;
    }

    @Override
    public T getFront() throws EmptyQueueException
    {
        if (isEmpty())
            throw new EmptyQueueException();

        return reversed ? tail.getItem() : head.getItem();
    }

    @Override
    public T getBack() throws EmptyQueueException
    {
        if (isEmpty())
            throw new EmptyQueueException();

        return reversed ? head.getItem() : tail.getItem();
    }

    @Override
    public void enqueueFront(T itm)
    {
        DoubleNode<T> newNode = new DoubleNode<T>(itm);

        if (isEmpty())
        {
            head = newNode;
            tail = newNode;
        }
        else if (reversed)
        {
            newNode.setNext(tail);
            tail.setPrev(newNode);
            tail = newNode;
        }
        else
        {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
    }

    @Override
    public void enqueueBack(T itm)
    {
        DoubleNode<T> newNode = new DoubleNode<T>(itm);

        if (isEmpty())
        {
            head = newNode;
            tail = newNode;
        }
        else if (reversed)
        {
            newNode.setPrev(head);
            head.setNext(newNode);
            head = newNode;
        }
        else
        {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    @Override
    public T dequeueFront() throws EmptyQueueException
    {
        if (isEmpty())
            throw new EmptyQueueException();

        DoubleNode<T> removed;

        if (reversed)
        {
            removed = tail;
            tail = tail.getPrev();

            if (tail == null)
                head = null;
            else
                tail.setNext(null);
        }
        else
        {
            removed = head;
            head = head.getNext();

            if (head == null)
                tail = null;
            else
                head.setPrev(null);
        }

        removed.setNext(null);
        removed.setPrev(null);
        return removed.getItem();
    }

    @Override
    public T dequeueBack() throws EmptyQueueException
    {
        if (isEmpty())
            throw new EmptyQueueException();

        DoubleNode<T> removed;

        if (reversed)
        {
            removed = head;
            head = head.getNext();

            if (head == null)
                tail = null;
            else
                head.setPrev(null);
        }
        else
        {
            removed = tail;
            tail = tail.getPrev();

            if (tail == null)
                head = null;
            else
                tail.setNext(null);
        }

        removed.setNext(null);
        removed.setPrev(null);
        return removed.getItem();
    }

    @Override
    public boolean isEmpty()
    {
        return head == null;
    }

    @Override
    public void clear()
    {
        head = null;
        tail = null;
        reversed = false;
    }

    @Override
    public void reverse()
    {
        reversed = !reversed;
    }

    @Override
    public boolean isReversed()
    {
        return reversed;
    }

    /**
     * Returns the deque from its logical front to its logical back,
     * with one item on each line.
     *
     * @return the contents of the deque.
     */
    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();
        DoubleNode<T> current = reversed ? tail : head;

        while (current != null)
        {
            result.append(current.getItem()).append("\n");
            current = reversed ? current.getPrev() : current.getNext();
        }

        if (result.length() > 0)
            result.setLength(result.length() - 1);

        return result.toString();
    }
}
