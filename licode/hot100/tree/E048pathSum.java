package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 路径总和
 */
public class E048pathSum {
    public int pathSum(TreeNode root, int targetSum) {
        //前缀和 相同前缀和的数量
        Map<Long,Integer> prefix = new HashMap<>();
        prefix.put(0L,1);
        return dfs(root,prefix,0,targetSum);
    }

    /**
     *
     * @param root
     * @param prefix 前缀和，数量
     * @param curr 从根节点到当前节点的和
     * @param targetSum 目标值
     * @return
     */
    public int dfs(TreeNode root, Map<Long,Integer> prefix,long curr,int targetSum){
        if(root == null){
            return 0;
        }
        int ret;
        //根节点到当前节点的值之和
        curr += root.val;
        //判断是否存在节点到当前节点 路径值之和等于 targetSum
        //返回满足的数量
        ret = prefix.getOrDefault(curr-targetSum,0);
        //保存根节点到当前节点的和，作为下一个节点的前缀和
        prefix.put(curr,prefix.getOrDefault(curr,0)+1);
        //递归左节点
        ret += dfs(root.left,prefix,curr,targetSum);
        //递归右节点
        ret += dfs(root.right,prefix,curr,targetSum);
        //当一个节点判断完之后，需要将记录的前缀和 - 1
        prefix.put(curr,prefix.getOrDefault(curr,0)-1);
        return ret;
    }
}
