package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 */
public class E036inorderTraversal {
    List<Integer> res = new ArrayList<>();//定义结果集
    public List<Integer> inorderTraversal(TreeNode root) {
        addM(root);
        return res;
    }
    public void addM(TreeNode node){
        if(node == null){
            return;
        }
        addM(node.left);
        res.add(node.val);
        addM(node.right);
    }

}

