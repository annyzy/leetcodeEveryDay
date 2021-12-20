import java.util.*;

public class BuySellBook {
    public void buysell( int[] buyOffers, int[] sellOffers, int buyPrice, int sellPrice){
        //max heap to store the buy offers
        PriorityQueue<Integer> buy = new PriorityQueue<Integer>( (a,b) -> b-a );
        //min heap to store the sell offers
        PriorityQueue<Integer> sell = new PriorityQueue<Integer>( (a,b) -> a-b );

        for(int b: buyOffers) buy.add(b);
        for(int s: sellOffers) sell.add(s);

        /*Tim offers to SELL at $150. 
        This will not match. 
        No one is willing to buy at that price so we save the offer.*/
        if(sellPrice > buy.peek()){
            sell.add(sellPrice);
            System.out.println("Elements of updated sell offers " + sell);
        }else{
            int canBuy = buy.poll();
            System.out.println("Can buy " + canBuy);
        }

        if(buyPrice  > sell.peek()){
            int canSell = sell.poll();
            System.out.println("Can sell " + canSell);
        }else{
            buy.add(buyPrice);
            System.out.println("Elements of updated buy offers " + buy);
        }
    }

    public static void main(String[] args){
        BuySellBook offer = new BuySellBook();
        int[] buyOffers = new int[]{100, 100, 99, 99, 97, 90};
        int[] sellOffers = new int[]{109, 110, 110, 114, 115, 119};

        System.out.println("Buy offers are " + Arrays.toString(buyOffers));
        System.out.println("Sell offers are " + Arrays.toString(sellOffers));
        offer.buysell(buyOffers, sellOffers, 200, 150);
    }
}