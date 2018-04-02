
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
        System.out.println(deal.revealHole());
        //Player takes turn
    }
}
