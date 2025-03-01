package array;

import java.util.ArrayList;
import java.util.List;

public  class E15spiralOrder {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int iCount = matrix.length;//行数
        int jCount = matrix[0].length;//列数
        //定义上下左右边界
        //规则：左闭右闭
        int l = 0;
        int r = jCount - 1;
        int top = 0;
        int bottom = iCount - 1;
        List<Integer> res = new ArrayList<>();
        while (l<=r&&top<= bottom){
            //读取上左到右
            for(int j = l;j<=r;j++){
                res.add(matrix[top][j]);
            }
            //读取右上到下
            for(int i = top+1;i<=bottom;i++){
                res.add(matrix[i][r]);
            }
            if(l<r&&top<bottom){
                //读取下右到左
                for(int j = r-1;j>l;j-- ){
                    res.add(matrix[bottom][j]);
                }
                //读取左下到上
                for(int i = bottom;i>top;i--){
                    res.add(matrix[i][l]);
                }
            }
            l++;
            r--;
            top++;
            bottom--;
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}};
        List<Integer> integers = spiralOrder(m);
        integers.forEach(System.out::println);
    }
}
