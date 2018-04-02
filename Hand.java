import java.util.ArrayList;
/**
 * Hand.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class Hand
{
    private ArrayList<Card> cards;
    public Hand(){ 
        cards=new ArrayList<Card>();

    }

    /**
     * This method takes an input of a Card n and adds it to the ArrayList containing all cards in the hand.
     * @param: Card n
     * @return: none (void)
     * @author: Ryan
     * @author_comment: Ryan
     */
    public void addCard(Card n){ 
        cards.add(n);   
    }
/**
     * This method removes the first card in the hand.
     * @param: none
     * @return: Card
     * @author: Ryan
     * @author_comment: Ryan
     */
    public Card removeCard(){ //Ryan
        return cards.remove(0);
    }
/**
     * This method returns the first card in the hand.
     * @param: none
     * @return: Card
     * @author: Ryan
     * @author_comment: Ryan
     */
    public Card getFirst(){ 
        return cards.get(0);
    }
/**
     * This method returns all cards that are not the first card in the hand.
     * @param: none
     * @return: ArrayList<Card>
     * @author: Ryan
     * @author_comment: Ryan
     */
    public ArrayList<Card> getOppositeOfFirst(){ 
        ArrayList<Card> temp=cards;
        temp.remove(0);
        return temp;
    }
/**
     * This method returns the total value of all cards in the hand.
     * @param: none
     * @return: int
     * @author: Ryan
     * @author_comment: Ryan
     */
    public int getTotalValue(){
        int value=0;
        for(Card c: cards){
            value+=c.getCardValue();
        }
        return value;
    }
    /**
     * This method prints all of the cards in the hand.
     * @param: none
     * @return: none (void)
     * @author: Pradnya
     * @author_comment: Ryan
     */
    public void Print(){ 
        for(Card c:cards){
            System.out.println(c);
        }
    }
        
   
}
