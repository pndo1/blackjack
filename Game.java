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
        Scanner scan=new Scanner(System.in);
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
        if(playerValue==21){
            deal.endRound("p","blackjack");   
        }
        System.out.println("The dealer's second card is: "+deal.revealOpposite().get(0)+" with a value of: "+deal.revealOpposite().get(0).getCardValue());
        if(deal.revealOpposite().get(0).getCardValue()==10){
            if(deal.revealOpposite().get(0).getCardValue()+deal.revealHole().getCardValue()==21){
                deal.endRound("d","blackjack");   
            }
        }
        System.out.println("Would you like to hit or stand?");
        String t=scan.nextLine();
        if(t.equals("hit"))
            player.hit();
        System.out.println("You have: ");
        System.out.println("The dealer is taking his turn");
        deal.takeTurn();
        playerValue=0;
        for(Card c:player.revealCards()){
            playerValue+=c.getCardValue();
            System.out.println(c);
        }
        System.out.println("The value is: "+playerValue);
        //Player takes turn
    }
}
