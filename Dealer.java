import java.util.ArrayList;
import java.util.Scanner;
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
    private static Player player;
    private String name;
    private Scanner scan;
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
    public Dealer(int c, String name){
        scan=new Scanner(System.in);
        name=name;
        chips=c;//is this working
        player=new Player(c);
    }

    public void startNewRound(int bet){
        numChips=0;chipsWonPlayer=0;chipsWonDealer=0;
        chipsPlayedPlayer=bet;
        chipsPlayedDealer=0;
        shoe=new Shoe(4);
        hand=new Hand();

        player.hit();
        takeTurn();
        player.hit();
        takeTurn();
        //System.out.println("You have: ");
        int playerValue=0;
        for(Card ca:player.revealCards()){
            playerValue+=ca.getCardValue();
            //System.out.println(ca);
        }
        //System.out.println("The value is: "+playerValue);
        if(playerValue==21){
            endRound("p","blackjack");   
        }
        System.out.print("The dealer's second card is: "+revealOpposite().get(0)+" with a value of: "+revealOpposite().get(0).getCardValue());
        if(revealOpposite().get(0).getCardValue()==10){
            if(revealOpposite().get(0).getCardValue()+revealHole().getCardValue()==21){endRound("d","blackjack");   
            }
        }
        if(isSecondAce()){
            System.out.print("Would you like to buy insurance? ");
            String insure=scan.next();
            if(insure.equals("yes")){
                System.out.print("How many chips would you like to buy? Maximum of "+chipsPlayedPlayer/2);
                int insureChips=scan.nextInt();
                player.buyInsurance(insureChips);
            }
        }
    }

    public void playRound(){
        boolean playerOn=true;
        boolean dealerOn=true;
        boolean win=false;
        int playerTurn=0;
        System.out.println("You have: ");
        int playerValue=0;
        for(Card ca:player.revealCards()){
            playerValue+=ca.getCardValue();
            System.out.println(ca);
        }
        while(playerOn && !win){
            System.out.print("\nWould you like to hit, stand, or double down? ");
            String t=scan.next();
            if(t.equals("hit")){
                System.out.println("You now have: ");
                player.hit();        playerValue=0;
                for(Card c:player.revealCards()){
                    playerValue+=c.getCardValue();
                    System.out.println(c);
                }
                System.out.println("The value is: "+playerValue);
            }
            if(t.equals("double down")){
                System.out.println("You now have: ");
                chipsPlayedPlayer*=2;
                player.doubleDown();        playerValue=0;
                for(Card c:player.revealCards()){
                    playerValue+=c.getCardValue();
                    System.out.println(c);
                }
                System.out.println("The value is: "+playerValue);
            }
            if(playerValue==21){
                win=true;
                playerOn=false;
                endRound("p","blackjack"); 
                System.out.println("player blackjack");
            }
            if(playerValue>21){
                win=true;
                playerOn=false;
                endRound("p","bust");   
                System.out.println("player bust");
            }
            if(playerValue<21 && player.revealCards().size()==5){
                win=true;
                playerOn=false;
                endRound("p","charlie");
                System.out.println("player charlie");
            }
            if(t.equals("stand")){
                playerOn=false;
            }
        }
        System.out.println("The dealer is taking his turn");
        System.out.println("The dealer's deck is: ");
        System.out.println(revealHole()+"\n"+revealOpposite().get(0));
        while(dealerOn && getValue()<17 && !win){
            takeTurn();
            if(getValue()==21){
                win=true;
                dealerOn=false;
                endRound("d","blackjack");
                System.out.println("dealer blackjack");
            }
            if(getValue()>21){
                win=true;
                dealerOn=false;
                endRound("d","bust");  
                System.out.println("dealer bust");
            }
            if(getValue()<21 && hand.reveal().size()==5){
                win=true;
                dealerOn=false;
                endRound("d","charlie");
                System.out.println("dealer charlie");
            }
        }      
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
     * This method reveals the other cards in the dealer's hand by calling the getOppositeOfFirst() method from the hand. 
     * @param: none
     * @return: Card
     * @Method author: Ryan
     * @Javadocs author: Ryan
     */
    public ArrayList<Card> revealOpposite(){
        return hand.getOppositeOfFirst();   
    }

    /**
     * This method reveals the value of all of the cards in the dealer's hand. 
     * @param: none
     * @return: int
     * @Method author: Ryan
     * @Javadocs author: Ryan
     */
    public int getValue(){

        return hand.getTotalValue();   
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
        if(player.getHasInsurance()){

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
