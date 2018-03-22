
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
    public Dealer(int c){
        chips=c;
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
     * @author: Ryan
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
     * @author: Ryan
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
     * @author: Ryan

     */
    public static Card dealCard(){
        return shoe.dealCard();
    }

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
        }
        else if(c.equals("bust")){
        }
        else if(c.equals("beat")){

        }
        if(Player.getHasInsurance()){
            
            }
    }

    public void push(){
        chipsWonDealer+=chipsPlayedDealer;
        chipsWonPlayer+=chipsPlayedPlayer;
        numChips=0;
    }

    public static int getChipsPlayedPlayer(){return chipsPlayedPlayer;}

    public static boolean isSecondAce(){return hand.getOppositeOfFirst().get(0).isAce();}

    public static void addChipsPlayedPlayer(int n){chipsPlayedPlayer+=n; numChips+=n;}
}
