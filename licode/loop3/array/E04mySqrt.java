import java.util.logging.Level;

public class E04mySqrt {
    public int mySqrt(int x) {
        int l = 1;
        int r = x;
        int candidate = 0;//候选值
        //左闭右闭
        while (l <= r){
            int mid  = (r - l) / 2 + l;
            long mm = (long)mid * mid;
           if(mm > x){
                r = mid - 1;
            }else if(mm < x){
                candidate = mid;
                l = mid + 1;
            }else {
               return mid;
           }
        }
        return candidate;
    }
}
