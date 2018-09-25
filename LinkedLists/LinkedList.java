import java.util.NoSuchElementException;
/**
 * Kenneth Li
 */
public class LinkedList
{
    //instance variables
    private Node first;//all a LL is is a reference to the very first node

    class Node
    {
        //Old School
        //Any Object into and out of our LL
        //cast to type the object as we remove
        public Object data;
        public Node next;
    }
    
    /**
     * Default constructor for objects of class LinkedList
     */
    public LinkedList()
    {
        // initialise instance variables
        first = null;
    }
    /**
     * Adds an element to the front of the LL
     * @param element to add
     */
    public void addFirst(Object element)
    {
        Node newNode = new Node();
        newNode.data = element;//points to object
        newNode.next = first;
        first = newNode;
    }
    
    /**
     * Returns first element in the LL
     * @returns first element in the LL
     */
    public Object getFirst()
    {
        if (first == null){throw new NoSuchElementException();}
        return first.data;
    }
    
    /**
     * Removes the first element in the LL
     * @return the removed element
     */
    public Object removeFirst()
    {
        if(first == null){throw new NoSuchElementException();}
        Object data = first.data;
        first = first.next;
        return data;
    }
}
