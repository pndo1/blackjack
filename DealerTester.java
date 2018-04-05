
/**
 * DealerTester.java  
 *
 * @author: Matthew
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class DealerTester
{
    public static void main (String [] args)
    {
        //creates a Dealer object with 50 chips
        Dealer dealer = new Dealer(50, "Jackson");
        
        //tests the startNewRound() method
        dealer.startNewRound(25);
        
        //tests the playRound() method
        dealer.playRound();
        
        //tests the revealHole() method, will return first card in the Dealer's Hand
        System.out.println(dealer.revealHole());
        
    }
}
