package combine;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class E07restoreIpAddresses {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        backtracking(s,0,0);
        return res;
    }
    private void backtracking(String s,int index,int count){
        if(count == 3){
            //拼接所有剩余字符
            if(isValid(s,index,s.length()-1)){
                res.add(s);
            }
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if(isValid(s,index,i)){//如果截取字符串有效
                s = s.substring(0,i)+"."+s.substring(i+1);
                count++;
                //递归
                backtracking(s,i+2,count);
                //回溯
                count--;
                s = s.substring(0,i+1)+s.substring(i+2);//删除 '.'
            }else {
                break;
            }
        }
    }
    private boolean isValid(String s,int start,int end){
        if(start > end){
            return false;
        }
        if(s.charAt(start) == '0' && start != end){ //字符不止一位，以0开头
            return false;
        }
        int num = 0;
        for(int i = start;i<=end;i++){
            num = num * 10 + (s.charAt(i) - '0');//拼接
            if(num > 255){
                return false;
            }
        }
        return true;
    }
}
