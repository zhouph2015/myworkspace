package Cardcode;

import java.util.ArrayList;
import java.util.Random;

import Cardcode.Card.Rank;
import Cardcode.Card.Suit;




public class Deck {
    
    private ArrayList<Card> cardList;
    
    private int remaningCard;
    
    
    
    public Deck(){
        cardList = new  ArrayList<Card>();
        for(Suit suit: Suit.values()){
            for(Rank rank: Rank.values()){
                cardList.add(new Card(suit, rank));
            }
            
        }
        
        remaningCard= cardList.size();
            
    }
    
    public void shuffle(){
        Random rdm =new Random();
        for (int i = 0; i < cardList.size(); i++){
            int rdmIndex = Math.abs(rdm.nextInt())%cardList.size();
            if(rdmIndex != i){
                Card temp = cardList.get(i);
                Card temp1 = cardList.get(rdmIndex);
                cardList.remove(i);
                cardList.add(i, temp1);
                cardList.remove(rdmIndex);
                cardList.add( rdmIndex,temp);
            }
        }
    }
    
    public static void main(String[] args){
        
        Deck deck = new Deck();
        System.out.println("Before shuffle");
        System.out.println(deck.cardList);
        deck.shuffle();
        System.out.println("After shuffle");
        System.out.println(deck.cardList);
    }

}
