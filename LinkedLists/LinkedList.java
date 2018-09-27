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
    
    public ListIterator listIterator()
    {
        return new LinkedListIterator();
    }
    
    class LinkedListIterator implements ListIterator
    {
        private Node position;
        private Node previous; //remove
        private boolean isAfterNext;
        
        public LinkedListIterator()
        {
            position = null;
            previous = null;
            isAfterNext = false;
        }
        
        public Object next()
        {
            if(!hasNext()){throw new NoSuchElementException();}
            
            previous = position; //so I can remove item
            isAfterNext = true;
            
            if(position == null)
            {
                position = first;//address/reference to Objects
            }
            
            else{
                position = position.next;
            }
            return position.data;
        }
        
         /**
            * Tests if there is an element after the iterator position
            * @return true if there is an element after the iterator position
              */
        public boolean hasNext()
        {
            if (position == null)
            {
                return first != null;
            }
            else{
                return position.next != null;
            }
        }
        
        /**
         * Adds an element before the iterator position
         * and moves the iterator past the inserted element
         * @param element , the element to add
         */
        public void add(Object element)
        {
            if (position == null)
            {
                addFirst(element);
                position = first;
            }
            else
            {
                Node newNode = new Node();
                newNode.data = element;
                newNode.next = position.next;
                //now position and position.next point to newNode
                position.next = newNode;//set both because you need to call next in order to remove something
                position = newNode;
            }
            
            isAfterNext = false;
        }
        
        /**
         * Removes the last traversed element. This method may only be 
         * called after a call to the next method
         */
        public void remove()
        {
            if(!isAfterNext){throw new IllegalStateException();}
            
            if (position == first)
            {
                removeFirst();
            }
            
            else
            {
                previous.next = position.next;
            }
            position = previous;//previous "replaces" position
            //acts as if the position before this was called was removed since nothing points to it
            isAfterNext = false;
        }
    }
    
}
