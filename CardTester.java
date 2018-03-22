
/**
 * Write a description of class CardTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CardTester
{
    public static void main(String[] args)
    {
        Card [] deck = new Card[52];
        for (int i = 0; i < deck.length; i++)
            deck[i] = new Card(i);
        
        for (Card c: deck){
            System.out.print(c);
            System.out.println(" value: "+c.getCardValue());
            c.setAceToOne(true);
            System.out.println("New value: " + c.getCardValue());
            c.setAceToOne(false);
            System.out.println("New value: " + c.getCardValue());
            }
        }
    }

