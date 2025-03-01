package matrix;

/**
 * 旋转图像
 */
public class E020rotate {
    public void rotate(int[][] matrix) {
        //这是一个行列相等的矩阵
        int n = matrix.length;
        //外循环次数 每次改变两列
        int loop = n / 2;
        for (int i = 0; i < loop; i++) {
            //内循环次数，内循环次数与 每一行元素个数有关，有 3 个值，需要两次交换
            for (int j = i; j < n - i - 1; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}
