package tree;

public class E29lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归终止条件
        if(root == null || root == p || root ==q){
            return root;
        }
        //后序遍历
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null){
            //两个返回值都不是null，表示当前节点是根结点
            return root;
        }else if(left != null && right == null){
            //只有一个返回值，说明，另一个包含在left子树中，返回
            return left;
        }else if(right != null && left == null){
            return right;
        }else {
            return null;
        }
    }

}
