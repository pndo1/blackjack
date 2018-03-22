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
    public Hand(){ //Ryan
        cards=new ArrayList<Card>();

    }

    public void addCard(Card n){ //Ryan
        cards.add(n);   
    }

    public Card removeCard(){ //Ryan
        return cards.remove(0);
    }

    public Card getFirst(){ //Ryan
        return cards.get(0);
    }

    public ArrayList<Card> getOppositeOfFirst(){ //Ryan
        ArrayList<Card> temp=cards;
        temp.remove(0);
        return temp;
    }

    public int getTotalValue(){ //Ryan
        int value=0;
        for(Card c: cards){
            value+=c.getCardValue();
        }
        return value;
    }
    public void Print(){ //Pradnya
        for(Card c:cards){
            System.out.println(c);
        }
    }
        
   
}
