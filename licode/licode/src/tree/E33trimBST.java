package tree;

public class E33trimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null){
            return null;
        }
        if(root.val < low){
            return trimBST(root.right,low,high);
        }else if(root.val > high){
            return trimBST(root.left,low,high);
        }
        //当前节点保留
        root.left = trimBST(root.left,low,high);
        root.right =trimBST(root.right,low,high);
        return root;
    }
}
