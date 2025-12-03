package greedy;

import java.util.Arrays;

// https://leetcode.com/problems/assign-cookies/submissions/1845939963/

public class AssignCookies {
    public static void main() {
        int[] greed = {1, 5, 3, 3, 4};
        int[] cookies = {4, 2, 1, 2, 1, 3};

        Arrays.sort(greed);
        Arrays.sort(cookies);
        int ng = greed.length;
        int nc = cookies.length;

        int l=0, r=0;

        while(l<nc && r<ng){
            if(cookies[l]>=greed[r]){
                l++;r++;
            }
            else{
                l++;
            }
        }
        System.out.println("satisfied children : "+r);
    }
}
