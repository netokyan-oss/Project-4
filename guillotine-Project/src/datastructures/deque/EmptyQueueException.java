package datastructures.deque;

/**
 * A simple empty queue exception.
 * @author Wendy-Beth Minton
 */
public class EmptyQueueException extends RuntimeException
{
  /**
   * Just provide the default constructor. We don't want
   * to allow the user to choose the message associated
   * with the exception.
   */
  public EmptyQueueException()
  {
    super("Queue is empty.");
  }
}
