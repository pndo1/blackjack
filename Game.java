
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
    private static Player play;
    private static int numStartChips;
    public  Game(int n){
        numStartChips=n;
        play=new Player(numStartChips);
    }

    public static  void play(){
        while(numStartChips>0){
            deal.dealCard();
        }   
    }

    public static void main(String [] args){
        numStartChips=10;
        play=new Player(numStartChips);
        deal=new Dealer(numStartChips);
        play.hit();
        play.hit();
        System.out.println(deal.revealHole());
    }
}
