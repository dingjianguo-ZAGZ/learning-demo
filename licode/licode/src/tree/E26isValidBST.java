package tree;

public class E26isValidBST {
    public boolean isValidBST(TreeNode root) {
        return doIsValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean doIsValidBST(TreeNode node,long min,long max){
        if(node == null){
            return false;
        }
        if(node.val >= max || node.val <= min){
            return false;
        }
        return doIsValidBST(node.left,min,node.val)&doIsValidBST(node.right,node.val,max);
    }
}
