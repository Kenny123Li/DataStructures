

/**
 * Write a description of class CircArrayTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CircArrayTest
{
public static void main(String[]args)
{
    CircularArrayQueue q = new CircularArrayQueue();
    q.add("Tom");
    q.add("Diana");
    q.add("Harry");
    q.lastToFirst();
    while(!q.empty())
    {
        System.out.print(q.remove()+ " ");
    }
    System.out.println();
    System.out.println("Expected: Harry Tom Diana");
}
}
