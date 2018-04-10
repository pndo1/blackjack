import java.util.ArrayList;
/**
 * Hand.java  
 *
 * @method author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class Hand
{
    private ArrayList<Card> cards;
    /**
     * The constructor for the Hand class is below. It creates an object 
     * made up of an ArrayList of Cards.
     * @param: none
     * @return: none
     */
    public Hand(){ 
        cards=new ArrayList<Card>();

    }

    /**
     * This method takes an input of a Card n and adds it to the ArrayList containing all cards in the hand.
     * @param: Card n
     * @return: none (void)
     * @method author: Ryan
     * @javadocs author: Ryan
     */
    public void addCard(Card n){ 
        cards.add(n);   
    }

    /**
     * This method removes the first card in the hand and returns it.
     * @param: none
     * @return: Card
     * @method author: Ryan
     * @javadocs author: Ryan
     */
    public Card removeCard(){ //Ryan
        return cards.remove(0);
    }

    /**
     * This method returns the first card in the hand.
     * @param: none
     * @return: Card
     * @method author: Ryan
     * @javadocs author: Ryan
     */
    public Card getFirst(){ 
        return cards.get(0);
    }

    /**
     * This method returns all cards that are not the first card in the hand.
     * @param: none
     * @return: ArrayList<Card>
     * @method author: Ryan
     * @javadocs author: Ryan
     */
    public ArrayList<Card> getOppositeOfFirst(){ 
        ArrayList<Card> temp=new ArrayList<Card>();
        for(int i=1;i<cards.size();i++){
            temp.add(cards.get(i));
        }
        return temp;
    }

    /**
     * This method returns the total value of all cards in the hand by looping through all cards in the ArrayList<Card> cards.
     * @param: none
     * @return: int
     * @method author: Ryan
     * @javadocs author: Ryan
     */
    public int getTotalValue(){
        int value=0;
        for(Card c: cards){
            value+=c.getCardValue();
        }
        return value;
    }

    /**
     * This method reveals all of the cards in the hand.
     * @param: none
     * @return: ArrayList<Card>
     * @method author: Ryan
     * @javadocs author: Ryan
     */
    public ArrayList<Card> reveal(){ 
        return cards;
    }

}
