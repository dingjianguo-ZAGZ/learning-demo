package greedy;

public class E10lemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        //贪心：出20，优先找10 + 5
        for (int i = 0; i < bills.length; i++) {
            if(bills[i]==5){
                five++;
            }else {
                if(five > 0){
                    five--;
                }else {
                    return false;
                }
            }
            if(bills[i] == 10){
                ten++;
            }else if(bills[i] == 20){
                if(ten > 0){
                    ten--;
                }else if(five >= 2){
                    five -= 2;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
