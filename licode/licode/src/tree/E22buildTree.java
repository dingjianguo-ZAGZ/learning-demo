package tree;

import java.util.HashMap;
import java.util.Map;

public class E22buildTree {
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            //键：值 值：位置
            map.put(inorder[i],i);
        }
        return findTree(preorder,0,preorder.length,inorder,0,inorder.length);

    }
    public TreeNode findTree(int[] preorder, int preBegin,int preEnd,int[] inorder, int inBegin,int inEnd){
        if (preBegin >= preEnd || inBegin >= inEnd) {  // 不满足左闭右开，说明没有元素，返回空树
            return null;
        }
        int rootIndex = map.get(preorder[preBegin]);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        int length = rootIndex - inBegin;
        root.left = findTree(preorder,preBegin+1,preBegin+length+1,inorder,inBegin,rootIndex);
        root.right = findTree(preorder,preBegin+length+1,preEnd,inorder,rootIndex+1,inEnd);
        return root;

    }
}
