

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
        test.addFirst(word);
        test.addFirst(new String("Two"));
        
        String word2;
        
        //word2 = test.getFirst();//this returns an object
        //OLD school!! must cast the Object
        word2 = (String) test.getFirst();//this returns an 
        
        System.out.print(word2);
    }

}
