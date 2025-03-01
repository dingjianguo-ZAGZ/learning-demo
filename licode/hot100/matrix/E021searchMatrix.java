package matrix;

/**
 * 搜索矩阵
 */
public class E021searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        //在右上到左下的矩阵中搜索，以右上为起点比较
        int row = 0; // 行索引
        int col = matrix[0].length - 1; // 列索引
        //行加 列减
        while (row < matrix.length && col >= 0){
            if(matrix[row][col] == target){
                return true;
            }
            if(matrix[row][col] > target){
                //target出现在当前列的左边
                col--;
            }else {
                //target出现在当前列的右边
                row++;
            }
        }
        //没有找到
        return false;
    }
}
