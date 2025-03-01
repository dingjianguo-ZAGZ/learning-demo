package greedy;

import java.util.Arrays;

public class E01findContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        //胃口
        Arrays.sort(g);
        //饼干
        Arrays.sort(s);
        int index = 0;
        for (int i = 0; i < s.length; i++) {
            if(index <= g.length-1 && s[i]>=g[index]){
                res++;
                index++;
            }
        }
        return res;
    }
}
