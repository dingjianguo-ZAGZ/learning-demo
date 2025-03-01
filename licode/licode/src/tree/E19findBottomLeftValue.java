package tree;

import java.util.HashMap;
import java.util.Map;

public class E19findBottomLeftValue {
    int maxDepth = -1;
    int res = 0;
    public int findBottomLeftValue(TreeNode root) {
        if(root == null){
            return 0;
        }
        leftDepth(root,0);
        return res;

    }
    public void leftDepth(TreeNode node,int depth){
        if(node == null){
            return;
        }
        if(depth > maxDepth){
            maxDepth = depth;
            res = node.val;
        }
        //必须先遍历左子树，在左右子树层高相同的情况下，记录左子树的值不会被修改
        if (node.left != null) {
            leftDepth(node.left, depth+1);
        }
        if (node.right != null) {
            leftDepth(node.right, depth+1);
        }

    }
}
