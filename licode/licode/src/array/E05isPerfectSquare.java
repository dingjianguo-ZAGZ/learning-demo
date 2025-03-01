package array;

public class E05isPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int l = 1;
        int r = num;
        boolean result = false;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            long mm = (long) mid * mid;
            if (mm > num) {
                r = mid - 1;
            } else if (mm < num) {
                l = mid + 1;
            } else {
                result = true;
            }
        }
        return result;
    }
}
