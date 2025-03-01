package tree;

import java.util.Objects;

public class E11isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return doIsSymmetric(root, root);
    }
    private boolean doIsSymmetric(TreeNode left,TreeNode right){
        if(left == null &&  right == null){
            return true;
        }
        if(left == null ||  right == null){
            return false;
        }
        if(!Objects.equals(left.val,right.val)){
            return false;
        }
        boolean a = doIsSymmetric(left.left,right.right);
        boolean b = doIsSymmetric(left.right,right.left);
        return a & b;
    }
}
