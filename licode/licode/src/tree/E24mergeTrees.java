package tree;

public class E24mergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 != null){
            return root2;
        }else if(root2 == null && root1 != null){
            return root1;
        }else if(root1 == null && root2 == null){
            return null;
        }
        int r1 = root1.val;
        int r2 = root2.val;
        TreeNode root = new TreeNode(r1+r2);
        root.left = mergeTrees(root1.left,root2.left);
        root.right = mergeTrees(root1.right,root2.right);
        return root;
    }
}
