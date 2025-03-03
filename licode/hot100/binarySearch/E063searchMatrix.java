package binarySearch;

public class E063searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        //从右上角开始找
        //右上角元素小于target，向下找，反之向左找
        int row = matrix.length;
        int r = 0;
        int column = matrix[0].length;
        int c = column-1;
        while (c >= 0 && r < row){
            if(matrix[r][c] == target){
                return true;
            }
            if (matrix[r][c] > target) {
                c--;
            } else if (matrix[r][c] < target) {
                r++;
            }else {
                return true;
            }
        }
        return false;
    }
}
