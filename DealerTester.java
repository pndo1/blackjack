
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
        
        // //tests the startNewRound() method
        dealer.startNewRound(25);
        System.out.println();
        
        //tests the revealHole() method, will return first card in the Dealer's Hand
        System.out.println("First card is: " + dealer.revealHole());
        System.out.println();
        
        //tests the revealOpposite() method to reveal cards in the dealer's hand excluding the first card
        System.out.println("Other cards is: " + dealer.revealOpposite());
        System.out.println();
        
        //tests the getValue() method
        System.out.println(dealer.getValue());
        System.out.println();
        
        // tests the takeTurn method()
        dealer.takeTurn();
        System.out.println(dealer.revealOpposite());
        System.out.println();
        
        //tests the dealCard() method
        System.out.println(dealer.dealCard());
        System.out.println();
        
        //tests the getChipsPlayedPlayer();
        System.out.println(dealer.getChipsPlayedPlayer());
        System.out.println();
        
        //tests the isSecondAce() method
        System.out.println(dealer.isSecondAce());
        System.out.println();
        
        //tests the addChipsPlayedPlayer(int n) method
        dealer.addChipsPlayedPlayer(50);
        System.out.println(dealer.getChipsPlayedPlayer());
    }
}
