package tree;

/**
 * 二叉树的直径
 */
public class E040diameterOfBinaryTree {
    int res = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        //左子树的最大深度加上右子树的最大深度
        //每一次记录值，取最大值，因为可能左右子树深度差距很大，最长路径不经过根节点
        maxDepth(root);
        return res - 1;
    }

    /**
     * 深度优先搜索
     * @param node
     * @return 叶节点到这一层一共多少个节点
     */
    public int maxDepth(TreeNode node){
        //节点未null，这一层没有节点，返回 0
        if(node == null){
            return 0;
        }
        int maxLeft = maxDepth(node.left);
        int maxRight = maxDepth(node.right);
        //res 表示从一个节点到另一个节点 一共有几个节点
        // 等于左子树的层数 + 右子树的层数 + 1（连接他们的根节点）
        res = Math.max(res,maxLeft+maxRight+1);
        //maxLeft , maxRight表示的是左右子树的深度，层数还需要加上本层的节点 （+1）
        return Math.max(maxLeft,maxRight)+1;
    }
}
