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
    /*public static void play(){
    while(numStartChips>0){
    deal.dealCard();
    }   
    }*/

    /*
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
    }*/

    public static void main(String [] args){
        boolean playerOn=true;
        boolean dealerOn=false;
        boolean win=false;
        Scanner scan=new Scanner(System.in);

        System.out.print("Please enter a player name: ");
        String name=scan.next();

        System.out.print("Please enter the number of chips you own: ");
        int numStartChips = scan.nextInt();

        System.out.println("Please enter the amount of chips you would like to bet: ");
        int betChips = scan.nextInt();
        if(betChips%2==1){
            System.out.println("Please enter the amount of chips you would like to bet (a number divisible by 2, please): ");
            betChips = scan.nextInt();
        }
        Player player=new Player(numStartChips);
        Dealer deal=new Dealer(numStartChips);
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
            win=true;
            deal.endRound("p","blackjack");   
        }
        System.out.print("The dealer's second card is: "+deal.revealOpposite().get(0)+" with a value of: "+deal.revealOpposite().get(0).getCardValue());
        if(deal.revealOpposite().get(0).getCardValue()==10){
            if(deal.revealOpposite().get(0).getCardValue()+deal.revealHole().getCardValue()==21){
                win=true;
                deal.endRound("d","blackjack");   
            }
        }
        if(deal.isSecondAce()){
            System.out.print("Would you like to buy insurance? ");
            String insure=scan.next();
            if(insure.equals("yes")){
                System.out.print("How many chips would you like to buy? Maximum of "+betChips/2);
                int insureChips=scan.nextInt();
                player.buyInsurance(insureChips);
            }
        }
        while(playerOn && !win){
            System.out.print("\nWould you like to hit or stand? ");
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
            if(playerValue==21){
                win=true;
                playerOn=false;
                deal.endRound("p","blackjack"); 
                System.out.println("player blackjack");
            }
            if(playerValue>21){
                win=true;
                playerOn=false;
                deal.endRound("p","bust");   
                System.out.println("player bust");
            }
            if(t.equals("stand")){
                playerOn=false;
            }
        }
        System.out.println("The dealer is taking his turn");
        System.out.println("The dealer's deck is: ");
        System.out.println(deal.revealOpposite().get(0));
        while(!dealerOn && !win){
            deal.takeTurn();
            if(deal.getValue()==21){
                win=true;
                dealerOn=true;
                deal.endRound("d","blackjack");
                System.out.println("dealer blackjack");
            }
            if(deal.getValue()>21){
                win=true;
                dealerOn=true;
                deal.endRound("d","bust");  
                System.out.println("dealer bust");
            }
        }

    }
}