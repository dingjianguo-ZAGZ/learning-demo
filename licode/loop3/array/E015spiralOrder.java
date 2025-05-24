import java.util.ArrayList;
import java.util.List;

public class E015spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null){
            return res;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        int top = 0; //上边界
        int left = 0; //左边界
        int bottom = r-1; //下边界
        int right = c-1; //右边界
        while (left <= right && top <= bottom) {
            //遵循不变量原则，左闭右闭
            //上 左到右
           for (int column = left;column<=right;column++){
               res.add(matrix[top][column]);
           }
            //右 上到下
            for (int row = top+1;row<=bottom;row++){
                res.add(matrix[row][right]);
            }
            if(left < right && top < bottom){
                //下 右到左
                for (int column = right - 1;column>=left;column--){
                    res.add(matrix[bottom][column]);
                }
                //左 下到上
                for (int row = bottom-1;row>top;row--){
                    res.add(matrix[row][left]);
                }
            }
            //边界范围缩小
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
