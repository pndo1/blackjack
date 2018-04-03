
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
        Player player = new Player(50);
        System.out.println(player.revealCards());
        System.out.println();
        player.hit();
        System.out.println(player.revealCards());
        System.out.println();
        player.doubleDown();
        System.out.println(player.revealCards());
        System.out.println();
        player.buyInsurance();
        player.getHasInsurance();
    }
}
