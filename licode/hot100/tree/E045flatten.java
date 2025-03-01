package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 将二叉树展开为链表
 */
public class E045flatten {

    public void flatten(TreeNode root) {
        //把树左子树的元素加在根节点和右子树中间
        //实现过程：将根节点的右节点作为左子树最右节点的右节点
        //将根节点的左节点设为null
        TreeNode curr = root;
        while (curr != null){
            if(curr.left != null){
                //跟节点化为链表后的下一个节点
                TreeNode next = curr.left;
                //最右节点是右子树的前驱节点
                TreeNode pre = next;
                while (pre.right != null){
                    //找到最右节点
                    pre = pre.right;
                }
                //将右子树设为左子树最右节点的右节点
                pre.right = curr.right;
                //将当前节点的左节点设为空
                curr.left = null;
                //next是当前节点的下一个节点
                curr.right = next;
            }
            curr = curr.right;
        }
    }

    /**
     * 使用栈对二叉树进行前序遍历
     * @param root
     */
    public void preOrder(TreeNode root){
        List<TreeNode> list = new ArrayList<>();//前序遍历结果集
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()){
            while (node != null){
                //先遍历根节点
                list.add(node);
                stack.push(node);
                //迭代左子树
                node = node.left;
            }
            node = stack.pop();//获得当前节点
            //迭代右子树
            node = node.right;
        }
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i-1);
            TreeNode curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }
}
