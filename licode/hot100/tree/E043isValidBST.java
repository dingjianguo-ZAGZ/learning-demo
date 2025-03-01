package tree;

/**
 * 判断是否为二叉搜索树
 */
public class E043isValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root,long min,long max) {
        if(root == null){
            return true;
        }
        if(root.val <= min || root.val >= max){
            return false;
        }
        //如果当前节点是左节点，max 为根节点
        //如果当前节点是右节点，min 为根节点
        //注意：min,max是递归调用时传递过来的值，所以不同节点的min,max不同
        return isValidBST(root.left,min,root.val) && isValidBST(root.right,root.val,max);
    }
}
