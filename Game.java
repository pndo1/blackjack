import java.util.Scanner;
/**
 * Game.java  
 *
 * @author:Pradnya Wani, Ryan
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class Game
{
    private static Dealer deal;
    private static Scanner scan;
    public static void main(String [] args){
        scan=new Scanner(System.in);
        start();
        boolean play=true;
        while(play){
            System.out.println("Please enter the amount of chips you would like to bet: ");
            int betChips = scan.nextInt();
            if(betChips%2==1){
                System.out.println("Please enter the amount of chips you would like to bet (a number divisible by 2, please): ");
                betChips = scan.nextInt();
            }
            deal.startNewRound(betChips);
            deal.playRound();
            System.out.println("Next round? ");
            String next=scan.next();
            if(next.equals("no")){
                play=false;   
            }
        }
    }

    public static void start(){
        System.out.print("Please enter a player name: ");
        String name=scan.next();
        System.out.print("Please enter the number of chips each player will start with: ");
        int numStartChips = scan.nextInt();

        deal=new Dealer(numStartChips,name);
    }
}