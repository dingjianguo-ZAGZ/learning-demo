package tree;

public class E30lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        if(root.val > q.val && root.val > p.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        return root;
    }
}
