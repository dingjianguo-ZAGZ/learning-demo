package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class E050maxPathSum {
    //记录全局最大和
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return res;

    }

    /**
     * 子树的最大和
     * @param root
     */
    public int maxGain(TreeNode root){
        if(root == null){
            return 0;
        }
        //递归计算左右子节点的最大贡献值，如果左右子节点为负数，不纳入统计
        //使用max(0,)使用 0 过滤负数
        int leftGain = Math.max(maxGain(root.left),0);
        int rightGain = Math.max(maxGain(root.right),0);

        //节点最大贡献值 左中右相加
        int priceMax = root.val + leftGain + rightGain;

        //更新全局最大值
        res = Math.max(res,priceMax);

        //返回 左右 路径中较大值加上父节点向上递归
        return root.val + Math.max(leftGain,rightGain);
    }
}
