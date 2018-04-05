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
    private  boolean hasInsurance;
    private int chips;
    private  int insurance;

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

    public void clearCards(){
        hand = new Hand();   
    }

    /**
     * This method calls the dealCard() method in the Dealer to add a card to the player's hand 
     * of cards. 
     * @param: none
     * @return: none (void method)
     * @author: Matt Li
     */
    public void hit(Card card)
    {
        hand.addCard(card);
    }

    // /***
    // * This method doubles the number of chips bet by the player by calling the dealer's
    // * getChipsPlayedPlayer() and then deals one more card to the player by calling the 
    // * hit() method.
    // * @param: none
    // * @return: none (void)
    // * @author: Matt Li
    // */
    // public void doubleDown()
    // {
    // int a = Dealer.getChipsPlayedPlayer();
    // chips -= a;
    // Dealer.addChipsPlayedPlayer(a);
    // }

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
    public  boolean getHasInsurance()
    {
        return hasInsurance;
    }

    /**
     * This method returns the number of chips the player has. It will not be called in the Game,
     * but it has been written for testing purposes to make sure number of chips the player has
     * changes acordingly when it double downs or buys insurance.
     * @param: none
     * @return: int
     * @author: Matt
     * @javadocs author: Matt
     */
    public int getChips()
    {
        return chips;
    }

    /**
     * This method is used when the dealer takes chips from the player to remove a certain amoun
     */
    public void removeChips(int remove)
    {
        chips -= remove;
    }

    public void addChips(int add)
    {
        chips += add;
    }

    public ArrayList<Card> revealCards(){return hand.reveal();}
}
