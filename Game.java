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
        Scanner scan=new Scanner(System.in);

        System.out.print("Please enter a player name: ");
        String name=scan.next();

        System.out.print("Please enter the number of chips you own: ");
        int numStartChips = scan.nextInt();

        System.out.println("Please enter the amount of chips you would like to bet: ");
        int betChips = scan.nextInt();
        if(betChips%2==1){
            System.out.println("Please enter the amount of chips you would like to bet: ");
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
            deal.endRound("p","blackjack");   
        }
        System.out.println("The dealer's second card is: "+deal.revealOpposite().get(0)+" with a value of: "+deal.revealOpposite().get(0).getCardValue());
        if(deal.revealOpposite().get(0).getCardValue()==10){
            if(deal.revealOpposite().get(0).getCardValue()+deal.revealHole().getCardValue()==21){
                deal.endRound("d","blackjack");   
            }
        }
        if(deal.isSecondAce()){
            System.out.println("Would you like to buy insurance? ");
            String insure=scan.nextLine();
            if(insure.equals("yes")){
                System.out.println("How many chips would you like to buy? Maximum of "+betChips/2);
                int insureChips=scan.nextInt();
                player.buyInsurance(insureChips);
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