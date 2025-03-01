package tree;

import com.sun.source.tree.Tree;

import java.util.Stack;

public class E10invertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        doInvertTree(root);
        return root;

    }
    public void doInvertTree(TreeNode node){
        swap(node);
        doInvertTree(node.left);
        doInvertTree(node.right);
    }
    public void swap(TreeNode node){
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
