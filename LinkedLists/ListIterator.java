

/**
 * Write a description of class ListIterator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface ListIterator
{
    /**
     * moves the iterator past the next element
     * @return the traversed element
     */
    Object next();
    
    /**
     * Tests if there is an element after the iterator position
     */
    boolean hasNext();
}