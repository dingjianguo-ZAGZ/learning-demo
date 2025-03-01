package tree;

public class E35convertBST {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null){
            return null;
        }
        //递归找到最大值
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        if(root.left != null){
            root.left = convertBST(root.left);
        }
        return root;
    }

}
