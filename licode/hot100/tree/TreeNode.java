package tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, tree.TreeNode left, tree.TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}