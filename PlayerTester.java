
/**
 * PlayerTester.java  
 *
 * @author: Matthew
 * Assignment #:
 * 
 * Brief Program Description:
 * This is the tester for the Player class. It creates a Player object and checks all the methods 
 * of the Player class.
 *
 */
public class PlayerTester 
{
    public static void main (String [] args)
    {
        //creates a Player object and Dealer object with 50 chips each
        Player player = new Player(50);
        Dealer dealer = new Dealer(50);
        System.out.println("Number of chips: " + player.getChips());
        
        //tests the revealCards()method that shows what cards the player has
        System.out.println(player.revealCards());
        System.out.println();
        
        //tests the hit() method
        player.hit();
        System.out.println(player.revealCards());
        System.out.println();
        
        //tests the doubleDown() method
        player.doubleDown();
        System.out.println(player.revealCards());
        System.out.println("Number of chips: " + player.getChips());
        System.out.println();
        
        //tests the the buyInsurance() method and getHasInsurance() method
        player.buyInsurance(20);
        System.out.println(player.getHasInsurance());
        
        //creates a new Player object to test the buyInsurance() method and getHasInsurance()
        //this player should not be able to have insurance with the number of chips inputted
        Player player2 = new Player(50);
        player.buyInsurance(30);
        System.out.println(player.getHasInsurance());
    }
}
