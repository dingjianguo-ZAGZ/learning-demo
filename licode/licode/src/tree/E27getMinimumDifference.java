package tree;

public class E27getMinimumDifference {
    TreeNode prev;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
         traversal(root);
         return min;
    }
    public void traversal(TreeNode root){
        if(root == null){
            return;
        }
        //左
        traversal(root.left);
        //中
        if(prev != null){
            min = Math.min(min,root.val - prev.val);
        }
        prev = root;
        //右
        traversal(root.right);
    }

}
