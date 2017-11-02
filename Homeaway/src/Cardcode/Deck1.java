package Cardcode;

import Cardcode.Card.Rank;
import Cardcode.Card.Suit;

public class Deck1 {
    private static int CARD_NUM = 52;
    private Card[] cardlist;
    private int remainingCard;
    
    public Deck1() {
        cardlist = new Card[CARD_NUM];
        remainingCard = CARD_NUM;
        int k = 0;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cardlist[k++] = new Card(suit, rank);
            }
        }

    }
    
    public String toString(){
        String relts= "";
        for (int i = 0; i < cardlist.length; i++){
            relts+=cardlist[i].toString() +", ";
        }
        return relts;
    }
    
    public static void main(String[] args){
        
        Deck1 deck1 = new Deck1();
        System.out.println(deck1.toString());
        
       
    }

}
