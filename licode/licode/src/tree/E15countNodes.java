package tree;

import java.util.Stack;

public class E15countNodes {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0;
        int rightDepth = 0;
        while (left != null){
            left = left.left;
            leftDepth++;
        }
        while (right != null){
            right = right.right;
            rightDepth++;
        }
        //如果是完全二叉树，leftDepth和rightDepth是同步增长的
        if(leftDepth == rightDepth){
            //完全二叉树节点个数 2^n
            return (2 << leftDepth) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;

    }

    public static void main(String[] args) {
        int a = 2 << 1;
        System.out.println(a);
    }
}
