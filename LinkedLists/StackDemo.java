

/**
 * Write a description of class StackDemo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StackDemo
{
    public static void main(String[]args)
    {
        LinkedListStack s = new LinkedListStack();
        
        s.push("one");
        s.push("two");
        s.push("three");
        s.push("four");
        
        while(!s.isEmpty())
        {
            System.out.println(s.pop());
        }
    }
}
