package greedy;

import java.util.Arrays;

public class E09candy {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            //从左向右，给右边加
            candy[i] = ratings[i] > ratings[i-1] ? candy[i-1]+1 : 1;
        }
        for(int j = ratings.length - 2;j >= 0;j--){
            //从右往左，给左边加
            if(ratings[j] > ratings[j+1]){
                candy[j] = Math.max(candy[j],candy[j+1]+1);
            }
        }
        return Arrays.stream(candy).sum();
    }
}
