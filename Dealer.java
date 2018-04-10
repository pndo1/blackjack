import java.util.ArrayList;
import java.util.Scanner;

/**
 * Dealer.java
 *
 * @author: Assignment #:
 * <p>
 * Brief Program Description:
 */
public class Dealer {
    private static Shoe shoe;
    private static Hand hand;
    private static int chipsPlayedPlayer, chipsWonPlayer;
    private Player player;
    private String name;
    private Scanner scan;
    private boolean win;

    /**
     * The constructor for the Dealer class is below. It instantiates the Shoe and Hand that the Dealer controls. It
     * starts of setting the number of chips the player and dealer have won to 0 at the start of the game. It sets
     * the number of chips played by the player and dealer to 0 before the round starts. It also sets how many chips the
     * dealer has to start off the game, which is the input c. It deals two card from the Shoe and adds it to his hand.
     * It also keeps track of how many total chips are being bet with numChips, instantiated to 0 before the round.
     *
     * @param: int
     * @return: none
     * @Method author: Ryan
     * @Javadocs author: Matt
     */
    public Dealer(int c, String n) {
        shoe = new Shoe(4);
        scan = new Scanner(System.in);
        name = n;
        player = new Player(c);
        win = false;

    }

    /**
     * The dealCard() method allows the dealer to deal a card from the shoe.
     *
     * @param: none
     * @return: Card
     * @Method author: Ryan
     * @Javadocs author: Matt
     */
    public static Card dealCard() {
        return shoe.dealCard();
    }

    /**
     * The getChipsPlayedPlayer method returns the number of chips the player has bet.
     *
     * @param: none
     * @return: int
     * @Method author: Ryan
     * @Javadocs author: Matt
     */
    public static int getChipsPlayedPlayer() {
        return chipsPlayedPlayer;
    }

    /**
     * The isSecondAce method returns a boolean determining whether the second card in the dealer's hand is an ace or not.
     * It returns true if the second card is an ace and false if it is not.
     *
     * @param: none
     * @return: boolean
     * @Method author: Ryan
     * @Javadocs author: Matt
     */
    public static boolean isSecondAce() {
        return hand.getOppositeOfFirst().get(0).isAce();
    }

    /**
     * The addChipsPlayedPlayer method adds a certain number of chips that the player will bet to the chipsPlayedPlayer
     * variable to increase the number of chips the player played based on the input, and it also increases the total
     * number of chips in play accordingly.
     *
     * @param: int
     * @return: none (void)
     * @Method author: Ryan
     * @Javadocs author: Matt
     */
    public static void addChipsPlayedPlayer(int n) {
        chipsPlayedPlayer += n;
    }

    public void startNewRound(int bet) {
        if (shoe.getNumCardsInShoe() < 75)
            shoe.shuffleShoe();
        chipsWonPlayer = 0;
        if (player.getChips() < bet) {
            System.out.println("You bet too much. Reducing bet to total chips: " + player.getChips() + ".");
        }

        chipsPlayedPlayer = bet;
        win = false;

        hand = new Hand();
        player.newRound();
        player.hit(dealCard());
        takeTurn();
        player.hit(dealCard());
        takeTurn();
        int playerValue = 0;
        for (Card ca : player.revealCards()) {
            playerValue += ca.getCardValue();
        }
        if (playerValue == 21 && hand.getTotalValue() != 21) {
            System.out.println(name + "'s deck:\n");
            playerValue = 0;
            for (Card ca : player.revealCards()) {
                playerValue += ca.getCardValue();
                System.out.println(ca);
            }
            endRound("p", "blackjack");
            win = true;
        }
        if (!win) {
            System.out.print("\nThe dealer's deck is:\nUnknown\n" + revealOpposite().get(0));
            if (revealOpposite().get(0).getCardValue() == 10) {
                if (revealOpposite().get(0).getCardValue() + revealHole().getCardValue() == 21) {
                    endRound("d", "blackjack");
                    win = true;
                }
            }
            if (isSecondAce()) {
                System.out.print("\nThe dealer's second card is an ace.\nWould you like to buy insurance? ");
                String insure = scan.nextLine();
                if (insure.equals("yes")) {
                    System.out.print("How many chips would you like to buy? Maximum of " + chipsPlayedPlayer / 2 + ": ");
                    int insureChips = scan.nextInt();
                    player.buyInsurance(insureChips);
                }
            }
        }
    }

    public void playRound() {
        boolean playerOn = true;
        boolean dealerOn = true;
        int playerValue = 0;
        int playerTurn = 0;
        if (!win) {
            System.out.println("\n\n" + name + "'s deck:\n");
            for (Card ca : player.revealCards()) {
                playerValue += ca.getCardValue();
                System.out.println(ca);
            }
            System.out.println("\nThe value is: " + playerValue);
        }
        while (playerOn && !win) {
            System.out.print("\nWould you like to hit, stand, or double down? ");
            String t = scan.nextLine();
            if (t.equals("hit")) {
                System.out.println("\n" + name + "'s deck:\n");
                player.hit(dealCard());
                playerValue = 0;
                for (Card c : player.revealCards()) {
                    playerValue += c.getCardValue();
                    System.out.println(c);
                }
                System.out.println("\nThe value is: " + playerValue);
            } else if (t.equals("double down")) {
                System.out.println("\n" + name + "'s deck:\n");
                chipsPlayedPlayer *= 2;
                player.hit(dealCard());
                playerValue = 0;
                for (Card c : player.revealCards()) {
                    playerValue += c.getCardValue();
                    System.out.println(c);
                }
                System.out.println("\nThe value is: " + playerValue);
            }
            if (playerValue == 21) {
                win = true;
                playerOn = false;
                endRound("p", "blackjack");
            } else if (playerValue > 21) {
                win = true;
                playerOn = false;
                endRound("p", "bust");
            } else if (playerValue < 21 && player.revealCards().size() == 5) {
                win = true;
                playerOn = false;
                endRound("p", "charlie");
            }
            if (t.equals("stand")) {
                playerOn = false;
            }
        }
        if (dealerOn && !win) System.out.println("\nThe dealer is taking his turn");
        while (dealerOn && getValue() <= 21 && !win) {

            System.out.println("\nThe dealer's deck: ");
            System.out.println(revealHole() + "\n" + revealOpposite().get(0));
            takeTurn();
            playerValue = 0;
            for (Card ca : player.revealCards()) {
                playerValue += ca.getCardValue();
            }
            if (getValue() == 21) {
                win = true;
                dealerOn = false;
                endRound("d", "blackjack");
            } else if (getValue() > 21) {
                win = true;
                dealerOn = false;
                endRound("d", "bust");
            } else if (getValue() >= 17 && getValue() < playerValue) {
                endRound("p", "beat");
                dealerOn = false;
                win = true;
            } else if (getValue() >= 17 && getValue() > playerValue) {
                endRound("d", "beat");
                dealerOn = false;
                win = true;
            } else if (getValue() >= 17 && getValue() == playerValue) {
                endRound("p", "push");
                dealerOn = false;
                win = true;
            }

        }

    }

    /**
     * This method reveals the first card in the dealer's hand by calling the getFirst() method from the hand.
     *
     * @param: none
     * @return: Card
     * @Method author: Ryan
     * @Javadocs author: Matt
     */
    public Card revealHole() {
        return hand.getFirst();
    }

    /**
     * This method reveals the other cards in the dealer's hand by calling the getOppositeOfFirst() method from the hand.
     *
     * @param: none
     * @return: Card
     * @Method author: Ryan
     * @Javadocs author: Ryan
     */
    public ArrayList<Card> revealOpposite() {
        return hand.getOppositeOfFirst();
    }

    // /**
    // * The push method is used when there is a tie in a round. The player and dealer both get the number of chips they bet
    // * back, and the total number of chips in play is set to 0 since the round is now over.
    // * @param: none
    // * @return: none (void)
    // * @Method author: Ryan
    // * @Javadocs author: Matt
    // */
    // public void push(){
    // chipsWonDealer+=chipsPlayedDealer;
    // chipsWonPlayer+=chipsPlayedPlayer;
    // numChips=0;
    // }

    /**
     * This method reveals the value of all of the cards in the dealer's hand.
     *
     * @param: none
     * @return: int
     * @Method author: Ryan
     * @Javadocs author: Ryan
     */
    public int getValue() {

        return hand.getTotalValue();
    }

    /**
     * The takeTurn() method forces the dealer to hit or stand based on the total value of his cards, which is found
     * by calling the getTotalValue() method from the Hand class. If the total value of the dealer's cards is less
     * than 17, the dealer stands.
     *
     * @param: none
     * @return: void
     * @Method author: Ryan
     * @Javadocs author: Matt
     */
    public void takeTurn() {
        if (hand.getTotalValue() < 17) {
            hand.addCard(dealCard());
        }

    }

    /**
     * The endRound method is called at the end of the round and allocates the number of chips won by the player and dealer.
     *
     * @param: String, String
     * @return: none (void)
     * @Method author: Ryan
     * @Javadocs author: Matt
     */
    public void endRound(String w, String c) {

        System.out.println("endRound called " + c + " " + w);
        int playerValue = 0;
        System.out.println("\nPlayer cards");
        for (Card ca : player.revealCards()) {
            playerValue += ca.getCardValue();
            System.out.println(ca);
        }

        System.out.println("\nDealer cards");
        int dealerValue = 0;
        for (Card ca : hand.reveal()) {
            dealerValue += ca.getCardValue();
            System.out.println(ca);
        }
        System.out.println();
        if (c.equals("blackjack")) {
            if (w.equals("d")) {
                System.out.println("You lost blackjack, no chips :(");
            } else if (w.equals("p")) {
                System.out.println("You won blackjack!");
                chipsWonPlayer += chipsPlayedPlayer + chipsPlayedPlayer * 3 / 2;
            }
        } else if (c.equals("push")) {
            System.out.println("You tied");
            chipsWonPlayer += chipsPlayedPlayer;
        } else if (c.equals("charlie")) {
            System.out.println("You won a 5 card charlie!");
            chipsWonPlayer += (chipsPlayedPlayer * 2);
        } else if (c.equals("bust")) {
            if (w.equals("d")) {
                System.out.println("The dealer busted! You keep " + chipsPlayedPlayer + " chips.");

            } else if (w.equals("p")) {
                System.out.println("You busted!");
                player.removeChips(chipsPlayedPlayer);
            }
        } else if (c.equals("beat") && w.equals("p")) {
            System.out.println("You beat the dealer!");
            chipsWonPlayer += (chipsPlayedPlayer * 2);
        } else if (c.equals("beat") && w.equals("d")) {
            System.out.println("The dealer beat you.");
            player.removeChips(chipsPlayedPlayer);
        }
        if (player.getHasInsurance()) {
            chipsWonPlayer += player.getInsurance() * 3;

        }
        System.out.println("You've won: " + chipsWonPlayer + " chips.");
        player.addChips(chipsWonPlayer);
        chipsWonPlayer = 0;
        System.out.println("You have " + player.getChips() + " chips remaining");
    }
}
