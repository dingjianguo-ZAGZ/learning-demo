import java.util.HashSet;
import java.util.Set;

public class E202isHappy {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n) && n != 1){
            set.add(n);
            n = getSum(n);
        }
        return n == 1;

    }
    public int getSum(int n){
        int sum = 0;
        while (n > 0){
            int number = n % 10;
            sum += number * number;
            n /= 10;
        }
        return sum;
    }
}
