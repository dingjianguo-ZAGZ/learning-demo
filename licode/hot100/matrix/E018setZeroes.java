package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 矩阵置零
 */
public class E018setZeroes {
    public void setZeroes(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        //整体思想，如果一行/一列中出现了0，则将这一行，一列标记为true
        boolean[] row = new boolean[rowCount];//行标记
        boolean[] col = new boolean[colCount];//列标记
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if(matrix[i][j] == 0){
                    //标记
                    row[i] = col[j] = true;
                }
            }
        }
        //修改原数组
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if(row[i] || col[j]){
                    //行或列为true,修改整行/整列
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
