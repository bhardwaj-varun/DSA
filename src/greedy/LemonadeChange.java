package greedy;

public class LemonadeChange {
    static boolean lemonadeChange(int[] bills){
        int fives=0;
        int tens=0;
        for (int bill : bills) {

            if (bill == 5) {
                fives++;
            } else if (bill == 10) {
                if (fives > 0) {
                    tens++;
                    fives--;
                } else return false;
            } else if (bill == 20) {
                if (tens > 0 && fives > 0) {
                    tens--;
                    fives--;
                } else if (fives >= 3) {
                    fives -= 3;
                } else return false;
            }

        }
        return true;
    }
    static void main() {
        int [] bills1 ={5,5,5,10,20}; //true
        System.out.println(lemonadeChange(bills1));
        int [] bills2 ={5,5,10,10,20}; //false
        System.out.println(lemonadeChange(bills2));
    }
}
