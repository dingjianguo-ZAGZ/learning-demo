package tree;

import java.util.Arrays;

/**
 * 根据前序遍历和中序遍历构建二叉树
 */
public class E047buildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }
        //前序遍历第一个节点是根节点
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        //在中序遍历中找到这个节点
        for (int i = 0; i < inorder.length; i++) {
            if( rootVal == inorder[i]){
                //根据根节点的位置划分数组
                int[] inLeft = Arrays.copyOfRange(inorder,0,i);
                int[] inRight = Arrays.copyOfRange(inorder,i+1,inorder.length);
                //划分前序遍历数组
                int[] preLeft = Arrays.copyOfRange(preorder,1,i+1);
                int[] preRight = Arrays.copyOfRange(preorder,i+1,preorder.length);
                //构建左右子树
                root.left = buildTree(preLeft,inLeft);
                root.right = buildTree(preRight,inRight);

                //找到根节点的值后跳出循环
                break;
            }
        }
        return root;
    }
}
