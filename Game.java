import java.util.Scanner;
/**
 * Game.java  
 *
 * @author:Pradnya Wani
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class Game
{
    public static void main(String[]args){
        Player play;
        Dealer deal;
        Hand hand= new Hand();
        Scanner scan= new Scanner(System.in);
        System.out.print("Please enter a player name: ");
        String name=scan.next();

        System.out.print("Please enter the number of chips you own: ");
        int numChips = scan.nextInt();

        System.out.println("Please enter the amount of chips you would like to bet: ");
        int betChips = scan.nextInt();
        if(betChips%2==1){
            System.out.println("Please enter the amount of chips you would like to bet: ");
            betChips = scan.nextInt();
        }
        play= new Player(numChips);
        deal= new Dealer(numChips);

        deal.dealCard();

        System.out.println("Would you like to hit or stand: ");
        String playInput= scan.next();

        if(playInput.equals("hit")){
            play.hit();
        }
        
        deal.takeTurn();
        
        if(hand.getTotalValue()>=17){
           String dealInput="stand";
        }
        
        //if(playInput.
    }
}