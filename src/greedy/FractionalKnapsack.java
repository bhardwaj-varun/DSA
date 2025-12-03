package greedy;

import java.util.Arrays;
import java.util.Comparator;

// https://www.naukri.com/code360/problems/fractional-knapsack_975286
// https://www.geeksforgeeks.org/dsa/fractional-knapsack-problem/
//
class Item{
    int value;
    int weight;

    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}
class ItemComparator implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        double v1 = (double) o1.value /o1.weight;
        double v2 = (double) o2.value /o2.weight;
        return Double.compare(v2, v1);
    }
}

class Solution{
    Item[] items;

    public double solve(int W, Item[] items, int n){
        double totalValue = 0;
        double currentWeight = 0;
        Arrays.sort(items, new ItemComparator());
        for(int i = 0; i < n; i++){
            if(currentWeight + items[i].weight <= W) {
                totalValue += items[i].value;
                currentWeight += items[i].weight;
            }else {
                double remainingWeight = W - currentWeight;
                totalValue += (items[i].value /(double) items[i].weight) * remainingWeight;
                break;
            }
        }

        return totalValue;
    }
}
public class FractionalKnapsack {
    public static void main(String[] args) {
        int n =6;
//        50 40 90 120 10 200
//        40 50 25 100 30 45
        Item[] arr = { new Item(40, 50),
                       new Item(50, 40),
                       new Item(25, 90),
                       new Item(100, 120),
                       new Item(30, 10),
                       new Item(45, 200 )};

        int W = 200;
        Solution solution = new Solution();

        double ans = solution.solve(W, arr, 6);
        System.out.println("total value: " + ans);

    }
}