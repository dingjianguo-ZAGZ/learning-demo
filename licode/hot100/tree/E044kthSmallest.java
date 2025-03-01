package tree;

/**
 * 二叉搜索树中第 k 小的元素
 */
public class E044kthSmallest {
    int res = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        Smallest(root,k);
        return res;
    }
    public void Smallest(TreeNode root, int k){
        //采用计数的方式
        if(root == null) return;
        //递归终点
        if(count >= k) return;
        //找最左侧节点
        Smallest(root.left,k);
        //已经在左子树中找到了 k-1 个最小值
        //将当前的节点作为一个最小值，k-1
        if(++count == k) {
            res = root.val;
        }else {
            //递归右子树
            Smallest(root.right,k);
        }

    }
}
