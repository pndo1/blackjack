
/**
 * HandTester.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class HandTester //Pradnya
{
    public static void main(String[]args){
        // creates a Hand object
        Hand h1= new Hand();
        h1.addCard(new Card(4));
        h1.addCard(new Card(5));
        h1.addCard(new Card(6));
        h1.addCard(new Card(7));
        //tests the reveal method, which should print all the cards in h1
        System.out.println(h1.reveal());
        System.out.println();
        //tests the removeCard method to remove first Card in the Hand
        h1.removeCard();
        System.out.println(h1.reveal());
        System.out.println();
        System.out.println(h1.getFirst());
        System.out.println();
        //tests the getOppositeOfFirst method to reveal all the Cards in the Hand except the first one      
        System.out.println(h1.getOppositeOfFirst());
        System.out.println();
        System.out.println(h1.getTotalValue());
        System.out.println(h1.reveal());
    }

}
