package array;

public class E14generateMatrix {
    public int[][] generateMatrix(int n) {
        //每行每列都是n个元素，二维数组
        int[][] square = new int[n][n];
        int i = 0;//代表行
        int j = 0;//代表列
        int loop = n / 2;//矩阵的圈数，找规律得出，
        //当n为奇数时，向下取整，有中心值。n为偶数时，正好n/2圈
        int val = 1;//填充的值
        int begin = 0;//起始位置
        int offset = 1;//收缩长度，遵一定的填充规则（左闭右开）
        while (loop > 0) {
            //模拟上左到右
            for (j = begin; j < n - offset; j++) {
                square[begin][j] = val++;
            }//i = begin,j = n-1
            //模拟右上到下
            for (i = begin; i < n - offset; i++) {
                square[i][j] = val++;
            }//i = n-1,j=n-1
            //模拟下右到左
            for (; j >= offset; j--) {
                square[i][j] = val++;
            }//i=n-1,j=0
            //模拟左下到上
            for (; i >= offset; i--) {
                square[i][j] = val++;
            }
            //填充完一圈，起始位置，收缩长度改变
            begin++;
            offset++;
            loop--;
        }
        //当为奇数时，填充中心值
        if (n % 2 != 0) {
            square[begin][begin] = val;
        }
        return square;
    }
}
