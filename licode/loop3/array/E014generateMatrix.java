public class E014generateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int i = 0; //控制行
        int j = 0; //控制列
        int count = 1;
        int loop = n / 2;
        int start = 0;
        int offset = 1; //左闭右开
        while (loop > 0) {
            // 上 左到右
            for (j = start; j < n - offset; j++) {
                res[start][j] = count++; //i = 0 j = 2
            }
            //右 上到下
            for (i = start; i < n - offset; i++) {
                res[i][j] = count++; //j = 3,i = 2
            }
            //下 右到左
            for (; j >= offset; j--) {
                res[i][j] = count++; //i = 3 j = 1
            }
            //左 下到上
            for (; i >= offset; i--) {
                res[i][j] = count++; //j = 0 i = 1
            }
            //循环完一圈
            start++; // 1
            offset++; // 2
            loop--; //1

        }
        if (n % 2 != 0) {
            //填充中间
            res[start][start] = count;
        }
        return res;
    }
}
