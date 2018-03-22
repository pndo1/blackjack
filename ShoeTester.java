
/**
 * Write a description of class ShoeTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShoeTester
{
    public static void main (String [] args)
    {
        Shoe aShoe = new Shoe(2);
        aShoe.printShoe();
        
        System.out.println("\n\n");
        
        while (aShoe.getNumCardsInShoe() > 75)
        {
              System.out.println("Card Dealt:" + aShoe.dealCard());
        }
        aShoe.shuffleShoe();
        System.out.println("\n\n");
        aShoe.printShoe();
    }
}
