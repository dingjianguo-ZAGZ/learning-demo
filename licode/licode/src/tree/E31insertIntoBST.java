package tree;

import javax.crypto.Cipher;

public class E31insertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return getSort(root,val);
    }
    //判断节点位置
    private TreeNode getSort(TreeNode node,int val) {
        if(node == null){
            return new TreeNode(val);
        }
        //边递归边创建
        if(node.val > val){
            //递归创建左子树
            node.left = getSort(node.left,val);
        }else if(node.val < val){
            //递归创建右子树
            node.right = getSort(node.right,val);
        }
        return node;
    }
}
