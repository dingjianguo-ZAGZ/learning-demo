package array;

public class E16spiralArray {
    public static int[] spiralArray(int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return new int[]{};
        }
        int len = array.length*array[0].length;
        int[] arr = new int[len];
        int l = 0;
        int r = array[0].length-1;
        int top = 0;
        int bottom = array.length-1;
        int index = 0;
        while(l<=r&&top<=bottom){
            //上左到右
            for(int j = l;j<=r;j++){
                arr[index]=array[top][j];
                index++;
            }
            //右上到下
            for(int i = top+1;i<=bottom;i++){
                arr[index]=array[i][r];
                index++;
            }
            if(l<r&&top<bottom){
                //下右到左
                for(int j = r-1;j>l;j--){
                    arr[index]=array[bottom][j];
                    index++;
                }
                //左下到上
                for(int i = bottom;i>top;i--){
                    arr[index]=array[i][l];
                    index++;
                }
            }
            l++;
            r--;
            top++;
            bottom--;
        }
        return arr;
    }
    public static void main(String[] args) {
        int[][] array = new int[][]{
                {2,5},{8,4},{0,-1}
        };
        int[] ints = spiralArray(array);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
