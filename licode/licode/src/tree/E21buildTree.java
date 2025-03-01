package tree;

import java.util.Arrays;

public class E21buildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        //后序遍历数组的最后一个值一定是根节点的值
        int rootValue = postorder[postorder.length - 1];
        //有了根节点的值，创建根节点
        TreeNode root = new TreeNode(rootValue);
        //拿根节点的值，去中序遍历数组中找根节点的位置
        for (int i = 0; i < inorder.length; i++) {
            //在中序遍历数组中找到根节点位置
            if (inorder[i] == rootValue) {

                //根据根节点位置划分数组
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i); // 左子树的中序遍历
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length); // 右子树的中序遍历

                //划分后序遍历数组
                int[] postLeft = Arrays.copyOfRange(postorder, 0, i);// 左子树的后序遍历
                int[] postRight = Arrays.copyOfRange(postorder, i, postorder.length - 1); // 右子树的后序遍历

                //分别把后序数组左部分和中序数组左部分，以及后序数组右部分和中序数组右部分看做一颗数的后序遍历和中序遍历
                //递归调用buildTree方法返回根节点作为上一次返回根的左子树节点以及右子树节点
                root.left = buildTree(inLeft, postLeft);
                root.right = buildTree(inRight, postRight);

                //   切记！！ 在中序遍历数组中找到根的值后要跳出循环
                break;
            }
        }
        return root;
    }
}
