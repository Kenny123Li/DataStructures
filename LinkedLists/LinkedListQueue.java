/**
   Add a method firstToLast to this implementation of a queue.
   The method moves the element at the head of the queue to
   the tail of the queue. The element that was second in line
   will now be at the head.
*/
public class LinkedListQueue
{
   private Node head;
   private Node tail;

   /**
      Constructs an empty queue.
   */
   public LinkedListQueue()
   {
      head = null;
      tail = null;
   }

   /**
      Moves the head of the queue to the tail.
   */
   public void firstToLast()
   {
      tail.next = head;
      tail = head;
      head = head.next;
      tail.next = null;
      //add(remove());
   }
   
   public void lastToFirst()
   {
       Node temp = head;
       while(temp.next.data != tail.data)
       {
           temp = temp.next;
        }
       temp.next = null;
       tail.next = head;
       head = head.next;
       head = tail;
       tail = temp;
    }

   /**
      Checks whether this queue is empty.
      @return true if this queue is empty
   */
   public boolean empty()
   {
      return head == null;
   }

   /**
      Adds an element to the tail of this queue.
      @param newElement the element to add
   */
   public void add(Object newElement)
   {
       if(tail == null) //head must also be null
       {
           Node newNode = new Node();
           newNode.data = newElement;//set to passed in data
           newNode.next = null;
           tail = newNode;
           head = newNode;
       }
       else
       {
           Node newNode = new Node();
           newNode.data = newElement;//set to passed in data
           newNode.next = null;
           
           tail.next = newNode;//???newNode
           tail = newNode;
        }
   }

   /**
      Removes an element from the head of this queue.
      @return the removed element
   */
   public Object remove()
   {
       if(empty())
       {
           return null;
       }
       
       Object element = head.data;
       head = head.next;//moves the head towards the tail
       
       if(empty())//queue is empty
       {
           tail = null;
        }
       return element;
    }
   class Node
   {
      public Object data;
      public Node next;
   }
}






