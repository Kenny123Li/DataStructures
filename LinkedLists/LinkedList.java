import java.util.NoSuchElementException;
/**
 * Kenneth Li
 * LinkedList
 */
public class LinkedList
{
    //instance variables
    private Node first;//all a LL is is a reference to the very first node
    private int currentSize;
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
        currentSize = 0;
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
        currentSize++;
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
        currentSize--;
        return data;
    }
    
    public ListIterator listIterator()
    {
        return new LinkedListIterator();
    }
    
    public void reverse()
    {
        LinkedList rev = new LinkedList();
        Node current = first;
        while(current != null)
        {
            current = current.next;
            rev.addFirst(this.removeFirst());
        }
        first = rev.first;
    }
    
    public void realreverse()
    {
        Node previous = first;
        Node current = first.next;
        first.next = null;
 
        if(first == null){return;}
        while(current != null)
        {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        first = previous;
    }
    
    public int size()
    {
        int size = 0;
        Node current = first;
        while(current != null)
        {
            current = current.next;
            size++;
        }
        return size;
    }
    
    /*
     * returns object at given index
     * @param int index
     * @return object at index
     */
    public Object get(int n)
    {
        return getNode(n).data;//getNode returns the node we need so all we need to do is return its data
    }
    
    /*
     * sets object at given index and moves current object 1 down the array
     * @param int index, Object new data to put in
     */
    public void set(int n, Object newElement)
    {
        if(!(n==0))
        {
            Node temp = getNode(n);//gets curent node at index n
            Node previous = getNode(n-1);//gets node before index n
            Node add = new Node();//creates node to be added at index n
            add.data = newElement;
            previous.next = add;//makes add at the current index
            add.next = temp;//makes add's next node the node that was in that index before
        }
        else
        {
            addFirst(newElement);
        }
        
    }
        
    private Node getNode(int n)
    {
        Node move = first;
        while(n>=1)
        {
            move = move.next;
            n--;
        }
        return move;
    }
    
    /*
     * returns a boolean to see whether the object is in the list
     * @param Object to check
     * @return boolean true or false
     */
    public boolean contains(Object obj)
    {
        Node check = first;
        while(check.data != null)//traverses through all links in the linked list
        {
            if(check.data.equals(obj))//checks to see if any node has data equal to object
            {
                return true;//can stop checking rest of list if true
            }
            check = check.next;//follows link
        }
        return false;//if loop ends, then there are no matches
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
                currentSize ++;
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
                currentSize--;
            }
            position = previous;//previous "replaces" position
            //acts as if the position before this was called was removed since nothing points to it
            isAfterNext = false;
        }
    }
    
}
