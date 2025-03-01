package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 */
public class E019spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        //结果集
        List<Integer> res = new ArrayList<>();
        if(matrix == null){
            return res;
        }
        int rows = matrix.length; //行
        int columns = matrix[0].length; //列
        //模拟过程,控制循环变量
        int left = 0; // 左边界
        int right = columns - 1; // 右边界
        int top = 0; // 上边界
        int bottom = rows - 1; // 下边界
        //循环不变量原则，左闭右闭
        while (left <= right && top <= bottom){
            //上从左向右遍历
            for (int column = left; column <= right; column++) { // 0 1 2
                res.add(matrix[top][column]);
            }
            //右从上到下遍历
            for (int row = top + 1; row <= bottom; row++) { // 0 1
                res.add(matrix[row][right]);
            }
            if(left < right && top < bottom){
                //下从右向左遍历
                for (int column = right - 1; column > left; column--) {// 3 2 1
                    res.add(matrix[bottom][column]);
                }
                //左从下向上遍历
                for (int row = bottom; row > top ; row--){ // 2 1
                    res.add(matrix[row][left]);
                }
            }
            //模拟一圈，缩小一圈
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
