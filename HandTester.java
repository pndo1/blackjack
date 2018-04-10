
/**
 * HandTester.java  
 *
 * @author: Matt and Pradnya
 * @Comments: Matt
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class HandTester 
{
    public static void main(String[]args){
        // creates a Hand object
        Hand h1= new Hand();
        h1.addCard(new Card(18));
        h1.addCard(new Card(51));
        h1.addCard(new Card(39));
        h1.addCard(new Card(68));
        
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
        
        //tests the getTotalValue() method to total the number value of the Hand
        System.out.println(h1.getTotalValue());
        
        
    }

}
