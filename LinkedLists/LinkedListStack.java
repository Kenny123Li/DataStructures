import java.util.NoSuchElementException;

/**
   An implementation of a stack as a sequence of nodes.
*/
public class LinkedListStack
{
   private Node first;

   /**
      Constructs an empty stack.
   */
   public LinkedListStack()
   {
      first = null;
   }

   /**
      Adds an element to the top of the stack.
      @param element the element to add
   */
   /**
     * Adds an element to the front of the LL
     * @param element to add
     */
    public void push(Object element)
    {
        Node top = new Node();
        top.data = element;//points to object
        top.next = first;//don't lost that first reference
        first = top;
    }

   /**
      Removes the element from the top of the stack.
      @return the removed element
   */
    public Object pop()
    {
        if(first == null){throw new NoSuchElementException();}
        Object temp = first.data;
        first = first.next;
        return temp;
    }
    
   /**
      Checks whether this stack is empty.
      @return true if the stack is empty
   */
   public boolean isEmpty()
   {
       return first == null;
    }



   class Node
   {
      public Object data;
      public Node next;
   }
}
