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
    private static Dealer deal;
    public static void main(String [] args){
        start();
        deal.nextRound();
    }

    public static void start(){
        Scanner scan=new Scanner(System.in);
        System.out.print("Please enter a player name: ");
        String name=scan.next();
        System.out.print("Please enter the number of chips each player will start with: ");
        int numStartChips = scan.nextInt();
        System.out.println("Please enter the amount of chips you would like to bet: ");
        int betChips = scan.nextInt();
        if(betChips%2==1){
            System.out.println("Please enter the amount of chips you would like to bet (a number divisible by 2, please): ");
            betChips = scan.nextInt();
        }
        deal=new Dealer(numStartChips,name,betChips);

    }
}