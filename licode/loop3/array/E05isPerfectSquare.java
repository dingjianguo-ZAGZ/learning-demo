public class E05isPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int l = 0;
        int r = num;
        while (l <= r){
            int mid = (r - l)/2+l;
            long mm = (long) mid * mid;
            if(mm > num){
                r = mid - 1;
            }else if(mm < num){
                l = mid + 1;
            }else {
                return true;
            }
        }
        return false;
    }
}
