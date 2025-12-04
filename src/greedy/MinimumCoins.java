package greedy;

import java.util.ArrayList;
import java.util.List;

// https://www.naukri.com/code360/problems/find-minimum-number-of-coins_975277
public class MinimumCoins {
    static void main() {
        // Approach to store denominations
        int [] coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int V = 58;
        List<Integer> ans = new ArrayList<>();
        for(int i =  coins.length - 1; i>=0; i--){

            while(V >= coins[i]){
                V-=coins[i];
                ans.add(coins[i]);
            }
        }
        System.out.println("Total coins "+ ans.size());
        System.out.println("Coin denomination" + ans);
        // output : 50 5 2 1

        // Naive approach
        /*int[] coins = {2,5};
        int amount = 3;
        int count = 0;
        int index = coins.length-1;
        while(index>=0 && amount >0){
            if (index == 0 && (amount % coins[index] != 0)) break;
            if(amount >= coins[index]){
                count +=amount / coins[index];;
                amount = amount%coins[index];
            }
            index--;
        }
        System.out.println( (count >0 ) ? count : -1);*/


    }
}
