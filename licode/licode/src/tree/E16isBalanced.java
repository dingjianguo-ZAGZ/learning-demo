package tree;

import java.util.SortedMap;

public class E16isBalanced {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int leftDepth = hasChild(root.left);
        int rightDepth = hasChild(root.right);
        if(Math.abs(leftDepth - rightDepth) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);


    }
    public int hasChild(TreeNode node){
        if(node == null){
            return 0;
        }
        int depth = Math.max(hasChild(node.left),hasChild(node.right))+1;
        return depth;
    }

    public static void main(String[] args) {
        int abs = Math.abs(-2);
        System.out.println(abs);
    }
}
