package array;

public class E04mySqrt {
    public int mySqrt(int x) {
        int l = 1;
        int r = x;
        int result = 0;
        while(l<=r){
            int mid = l + ((r - l)>>>1);
            long mm = (long)mid * mid;
            if(mm < x){
                l = mid + 1;
                result = mid;
                //当mm < x时，mid可能是x最大的平方根，所以要将mid记录为候选值
            }else if(mm > x){
                r = mid - 1;
                //当mm > x时，mid的平方已经大于x，所以mid 不可能时x最大整数平方根，所以不用记录候选值
            }else{
                return mid;
            }
        }
        return result;
    }
}
