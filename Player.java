import java.util.ArrayList;
/**
 * Player.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public  class Player
{
    private Hand hand;
    private static boolean hasInsurance;
    private int chips;
    private static int insurance;

    /**
     * The constructor for the Player class is below. It creates a hand for the player and starts off with the player having
     * no insurance. It instantiates the number of chips of the player to the input when a Player object is created.
     * @param: int
     * @return: none
     * @author: Matt Li
     */
    public  Player(int numChips)
    {
        hand = new Hand();
        hasInsurance = false;
        chips = numChips;
    }

    /**
     * This method calls the dealCard() method in the Dealer to add a card to the player's hand 
     * of cards. 
     * @param: none
     * @return: none (void method)
     * @author: Matt Li
     */
    public void hit()
    {
        hand.addCard(Dealer.dealCard());
    }

    /***
     * This method doubles the number of chips bet by the player by calling the dealer's
     * getChipsPlayedPlayer() and then deals one more card to the player by calling the 
     * hit() method.
     * @param: none
     * @return: none (void)
     * @author: Matt Li
     */
    public void doubleDown()
    {
        int a = Dealer.getChipsPlayedPlayer();
        chips -= Dealer.getChipsPlayedPlayer();
        Dealer.addChipsPlayedPlayer(a);
        hit();
    }

    /**
     * This method lets the player buy insurance, with the Game class checking for the Dealer's second Ace. 
     * The c integer is the number of extra chips bet by the player.
     * @param: int c
     * @return: none (void)
     * @author: Ryan Mitchell
     */
    public void buyInsurance(int c)
    {
        if (c<=Dealer.getChipsPlayedPlayer()/2)
        {
            hasInsurance = true;

            insurance = c;
        }
    }

    /**
     * This method lets the dealer check if the player purchased insurance to determine scoring.
     * The actual scoring will be handled in the dealer class.
     * @param: none
     * @return: boolean
     * @author: Matt Li
     */
    public static boolean getHasInsurance()
    {
        return hasInsurance;
    }

    public ArrayList<Card> revealCards(){return hand.reveal();}
}
