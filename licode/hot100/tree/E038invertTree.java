package tree;

/**
 * 反转二叉树
 */
public class E038invertTree {
    public TreeNode invertTree(TreeNode root) {
        //把一棵树的左右子树交换
        if(root == null){
            return null;
        }
        TreeNode res = root;
        TreeNode left = res.left;
        TreeNode right = res.right;
        res.left = invertTree(right);
        res.right = invertTree(left);
        return res;
    }

}
