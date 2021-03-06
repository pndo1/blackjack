
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
        Dealer dealer = new Dealer(50, "Jackson");
        System.out.println("Number of chips: " + player.getChips());
        System.out.println();
        
        //tests the revealCards()method that shows what cards the player has, should be empty
        System.out.println(player.revealCards());
        System.out.println();
        
        //tests the hit() method
        player.hit(new Card(3));
        System.out.println(player.revealCards());
        System.out.println();
        
//<<<<<<< HEAD
        //tests the doubleDown() method
        //player.doubleDown();
        System.out.println(player.revealCards());
        System.out.println("Number of chips: " + player.getChips());
        System.out.println();
        
//=======
//>>>>>>> 8b96381ac2f02110dfbec46d015b60768dc3409c
        //tests the the buyInsurance() method and getHasInsurance() method
        player.buyInsurance(20);
        System.out.println(player.getHasInsurance());
        
        //creates a new Player object to test the buyInsurance() method and getHasInsurance()
        //this player should not be able to have insurance with the number of chips inputted
        Player player2 = new Player(50);
        player2.buyInsurance(30);
        System.out.println(player2.getHasInsurance());
    }
}
