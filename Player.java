
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
     * 
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
     * This method only allows the method to purchase insurance if the dealer's up-card ia an
     * Ace. If the dealer's up-card is an Ace, it changes the hasInsurance variable to true
     * and adds insurance by adding half of the total chips played by the player.
     * @param: none
     * @return: none (void)
     * @author: Matt Li
     */
    public void buyInsurance()
    {
        if (Dealer.isSecondAce())
        {
            hasInsurance = true;
            insurance = Dealer.getChipsPlayedPlayer()/2;
            //asdf
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
    
    
}
