
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
        Hand h1= new Hand();
        h1.addCard(new Card(4));
        h1.addCard(new Card(5));
        h1.addCard(new Card(6));
        h1.addCard(new Card(7));
        h1.Print();
        h1.removeCard();
        h1.Print();
        System.out.println();
        h1.getOppositeOfFirst();
        h1.Print();
        System.out.println();
        System.out.println(h1.getTotalValue());
        h1.Print();
    }

}
