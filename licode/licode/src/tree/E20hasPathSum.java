package tree;

public class E20hasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        return sum(root,targetSum);

    }
    public boolean sum(TreeNode node,int targetSum){
        if(node.val == targetSum && node.right == null && node.left == null){
            return true;
        }
        targetSum = targetSum - node.val;
        if(node.left != null){
            return sum(node.left,targetSum);
        }
        if(node.right != null){
            return sum(node.right,targetSum);
        }
        return false;
    }
}
