package Cardcode;


public class Card {
    
   
    
    private  final Suit suit;
    private   final Rank rank;
    
    public Card(Suit suit, Rank rank){
        this.suit =suit;
        this.rank = rank;
    }
    
    

    
    public Suit getSuit() {
        return suit;
    }

    public Rank getValue() {
        return rank;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return suit+"-"+rank;
    }
    
    public enum Suit{
        CLUB,DIAMOND,SPADE,HEART
    }

/* This represents the number of the card*/
    public enum Rank{
        ACE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING
    }

}


