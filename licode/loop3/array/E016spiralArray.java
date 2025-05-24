/**
 * 螺旋遍历二维数组
 */
public class E016spiralArray {
    public int[] spiralArray(int[][] array) {
        if(array == null || array.length == 0 || array[0].length == 0) {
            return new int[]{};
        }
        int rows = array.length;
        int columns = array[0].length;
        int left = 0;
        int right = columns - 1;
        int top = 0;
        int bottom = rows - 1;
        int index = 0;
        int[] res = new int[rows * columns];
        while (left <= right && top <= bottom) {
            //模拟过程，循环不变量，左闭右闭
            //上 左到右
            for (int c = left;c<=right;c++){
                res[index] = array[top][c];
                index++;
            }
            //右 上到下
            for (int r = top+1;r<=bottom;r++){
                res[index] = array[r][right];
                index++;
            }
            //只有当当前层的矩阵同时存在多行和多列时，才执行 "左→上" 的遍历。如果不满足此条件，则跳过这两步，直接收缩边界进入下一层。
            if(left < right && top < bottom){
                //下 右到左
                for (int c = right - 1;c>=left;c--){
                    res[index] = array[bottom][c];
                    index++;
                }
                //左 下到上
                for (int r = bottom - 1;r > left;r--){
                    res[index] = array[r][left];
                    index++;
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
