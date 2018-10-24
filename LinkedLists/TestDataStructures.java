

/**
 * Write a description of class TestDataStructures here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestDataStructures
{
    public static void main(String[] args){
        LinkedList test = new LinkedList();
        
        String word = "New";
        test.addFirst("five");
        test.addFirst(new String("four"));
        test.addFirst("three");
        test.addFirst("two");
        test.addFirst("one");
        test.addFirst("zero");
        ListIterator iter = test.listIterator();
        while(iter.hasNext())
        {
            System.out.println(iter.next());
        }
        System.out.println(test.get(1));
        System.out.println(test.get(2));
        test.set(1, "eight");
        System.out.println(test.get(0));
        System.out.println(test.get(1));
        System.out.println(test.get(2));
        System.out.println(test.get(3));
        System.out.println(test.contains("five"));
        
        while(iter.hasNext())
        {
            System.out.println(iter.next());
        }
        //test.realreverse();
        /*System.out.println(test.size());
        ListIterator iter = test.listIterator();
        while(iter.hasNext())
        {
            System.out.println(iter.next());
        }
        String word2;*/
        
        //word2 = test.getFirst();//this returns an object
        //OLD school!! must cast the Object
        //word2 = (String) test.getFirst();//this returns an object
        
        //System.out.print(word2);
        
        /*
         * In the implementation for 16.2, you set first = newNode first, but nothing references first, so you 
         * can't access it ever again, so setting newNode.next = first makes newNode point to itself
         * LinkedList test = new LinkedList();
         * test.add("hello")
         * test.add("hi")
         * ListIterator iter = test.listIterator()
         * while iter.hasnext()
         * {
         *     System.out.print(iter.next())
         *     }
         */
        
        
        
        /*
         * for 16.3 implementation:
         * when the iterator is at the end of the linked list, hasnext
         * would return true, since position isn't null, but the list
         * doesn't have anything after it, so while it should return
         * false, it returns true
         * LinkedList test = new LinkedList();
         * test.addFirst("hello");
         * ListIterator iter = test.listIterator();
         * iter.hasNext();
         * since iterator's current position is null, hasnext returns false, but there is
         * an element after it, so it's wrong
         */
        
        
    }

}
