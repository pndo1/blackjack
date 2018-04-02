
/**
 * Dealer.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class Dealer
{
    private static Shoe shoe;
    private static Hand hand;
    private static int chipsPlayedPlayer,chipsPlayedDealer,chips,numChips,chipsWonPlayer,chipsWonDealer;
    /**
     * The constructor for the Dealer class is below. It instantiates the Shoe and Hand that the Dealer controls. It 
     * starts of setting the number of chips the player and dealer have won to 0 at the start of the game. It sets
     * the number of chips played by the player and dealer to 0 before the round starts. It also sets how many chips the
     * dealer has to start off the game, which is the input c. It deals two card from the Shoe and adds it to his hand.
     * It also keeps track of how many total chips are being bet with numChips, instantiated to 0 before the round.
     * @param: int
     * @return: none
     * @Method author: Ryan
     * @Javadocs author: Matt
     */
    public Dealer(int c){
        chips=c;//is this working
        numChips=0;chipsWonPlayer=0;chipsWonDealer=0;
        chipsPlayedPlayer=0;
        chipsPlayedDealer=0;
        shoe=new Shoe(4);
        hand=new Hand();
        hand.addCard(dealCard());
        hand.addCard(dealCard());
    }
    /**
     * This method reveals the first card in the dealer's hand by calling the getFirst() method from the hand. 
     * @param: none
     * @return: Card
     * @Method author: Ryan
     * @Javadocs author: Matt
     */
    public Card revealHole(){
        return hand.getFirst();   
    }
    /**
     * The takeTurn() method forces the dealer to hit or stand based on the total value of his cards, which is found
     * by calling the getTotalValue() method from the Hand class. If the total value of the dealer's cards is less
     * than 17, the dealer stands.
     * @param: none
     * @return: void
     * @Method author: Ryan
     * @Javadocs author: Matt
     */
    public void takeTurn(){
        while(hand.getTotalValue()<17){
            hand.addCard(dealCard());
        }
    }
    /**
     * The dealCard() method allows the dealer to deal a card from the shoe.
     * @param: none
     * @return: Card
     * @Method author: Ryan
     * @Javadocs author: Matt
     */
    public static Card dealCard(){
        return shoe.dealCard();
    }
    /**
     * The endRound method is called at the end of the round and allocates the number of chips won by the player and dealer.
     * @param: String, String
     * @return: none (void)
     * @Method author: Ryan
     * @Javadocs author: Matt
     */
    public void endRound(String w,String c){
        if(c.equals("blackjack")){
            if(w.equals("d")){
                int chipWin=chipsPlayedDealer+chipsPlayedDealer*3/2;
                numChips-=chipWin;
                chipsWonDealer+=chipWin;
                chipsWonPlayer+=numChips;
                numChips=0;
            }
            else if(w.equals("p")){
                int chipWin=chipsPlayedPlayer+chipsPlayedPlayer*3/2;
                numChips-=chipWin;
                chipsWonPlayer+=chipWin;
                chipsWonDealer+=numChips;
                numChips=0;
            }
        }
        else if(c.equals("push")){
            chipsWonDealer+=chipsPlayedDealer;
            chipsWonPlayer+=chipsPlayedPlayer;
            numChips=0;
        }
        else if(c.equals("charlie")){
            chipsWonPlayer += (chipsPlayedPlayer*2);
            numChips = 0;
        }
        else if(c.equals("bust")){
            
        }
        else if(c.equals("beat")){
            chipsWonPlayer += (chipsPlayedPlayer*2);
            numChips = 0;
        }
        if(Player.getHasInsurance()){
            
            }
    }
    /**
     * The push method is used when there is a tie in a round. The player and dealer both get the number of chips they bet
     * back, and the total number of chips in play is set to 0 since the round is now over.
     * @param: none
     * @return: none (void)
     * @Method author: Ryan
     * @Javadocs author: Matt
     */
    public void push(){
        chipsWonDealer+=chipsPlayedDealer;
        chipsWonPlayer+=chipsPlayedPlayer;
        numChips=0;
    }
    /**
     * The getChipsPlayedPlayer method returns the number of chips the player has bet.
     * @param: none
     * @return: int
     * @Method author: Ryan
     * @Javadocs author: Matt
     */
    public static int getChipsPlayedPlayer(){return chipsPlayedPlayer;}
    /**
     * The isSecondAce method returns a boolean determining whether the second card in the dealer's hand is an ace or not.
     * It returns true if the second card is an ace and false if it is not.
     * @param: none
     * @return: boolean
     * @Method author: Ryan
     * @Javadocs author: Matt
     */
    public static boolean isSecondAce(){return hand.getOppositeOfFirst().get(0).isAce();}
    /**
     * The addChipsPlayedPlayer method adds a certain number of chips that the player will bet to the chipsPlayedPlayer
     * variable to increase the number of chips the player played based on the input, and it also increases the total
     * number of chips in play accordingly.
     * @param: int
     * @return: none (void)
     * @Method author: Ryan
     * @Javadocs author: Matt
     */
    public static void addChipsPlayedPlayer(int n){chipsPlayedPlayer+=n; numChips+=n;}
}
