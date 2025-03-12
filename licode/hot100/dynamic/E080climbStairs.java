package dynamic;

public class E080climbStairs {
    public int climbStairs(int n) {
        //特殊处理
        if(n <= 2){
            return n;
        }
        int[] dp = new int[n + 1]; //保存每一层楼梯有多少种方式，从第 0 楼开始
        //初始化
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
