package tree;

import java.util.*;

public class E28indMode {
    TreeNode prev;
    int maxCount;
    int count;
    ArrayList<Integer> res;
    public int[] findMode(TreeNode root) {
        //初始化全局变量
        prev = null;
        count = 0;
        maxCount = 0;
        res = new ArrayList();
        traversal(root);
        return res.stream().mapToInt(i -> i).toArray();

    }
    private void traversal(TreeNode root){
        if(root == null){
            return;
        }
        traversal(root.left);
        //当前节点为第一个节点或当前节点与前面的节点不重复，是新的开始节点
        if(prev == null || root.val != prev.val){
            count = 1;
        }else {
            count++;
        }
        //更新结果集合
        if(count > maxCount){
            //清空集合中之前的数据
            res.clear();
            res.add(root.val);
            maxCount = count;
        }else if(count == maxCount){
            res.add(root.val);
        }
        prev = root;
        traversal(root.right);
    }
}
