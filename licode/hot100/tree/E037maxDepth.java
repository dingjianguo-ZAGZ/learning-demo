package tree;

public class E037maxDepth {
    public int maxDepth(TreeNode root) {
        //一棵树的最大深度 = max(左右子树的最大深度)+1
        if(root == null){
            //说明该树没有高度
            return 0;
        }else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left,right)+1;
        }
    }

}
