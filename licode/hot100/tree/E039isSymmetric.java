package tree;

import java.util.logging.Level;

/**
 * 判断一棵二叉树是否轴对称
 */
public class E039isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        //分治思想：判断一棵二叉树 左子树的左节点等于右子树的右节点
        if(root == null){
            return true;
        }
        return isSymmetric(root.left,root.right);
    }
    public boolean isSymmetric(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return true;
        }else if((left == null && right != null) || (left != null && right == null)){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        boolean b1 = isSymmetric(left.left,right.right);
        boolean b2 = isSymmetric(left.right,right.left);
        return b1 && b2;
    }
}
