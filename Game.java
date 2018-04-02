import java.util.Scanner;
/**
 * Game.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class Game
{
    private static Dealer deal;
    private static Player player;
    private static int numStartChips;
    public  Game(int n){
        numStartChips=n;
        player=new Player(numStartChips);
    }

    public static void play(){
        while(numStartChips>0){
            deal.dealCard();
        }   
    }

    public static void main(String [] args){
        numStartChips=10;
        player=new Player(numStartChips);
        deal=new Dealer(numStartChips);
        player.hit();
        deal.takeTurn();
        player.hit();
        deal.takeTurn();
        System.out.println("You have: ");
        int playerValue=0;
        for(Card c:player.revealCards()){
            playerValue+=c.getCardValue();
            System.out.println(c);
        }
        System.out.println("The value is: "+playerValue);
        System.out.println("The dealer's second card is: ");
        
        
        System.out.println("Would you like to hit or stand?");
        //Player takes turn
    }
}
