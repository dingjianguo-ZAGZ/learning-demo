package tree;

import java.util.*;

/**
 * 二叉树的层序遍历
 */
public class E041levelOrder {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return res;
        }
        maxDepth(root);
        return res;
    }
    public void maxDepth(TreeNode root){
        if(root == null){
            return;
        }
        //定义队列，保存每一层的节点
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        //记录每一层节点的个数
        int c1 = 1;
        //递归遍历每一层
        //就是遍历队列中每个节点的子节点
        while (!queue.isEmpty()){
            //记录下一层的节点数
            int c2 = 0;
            //创建存储每一层节点的列表
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < c1; i++) {
                //将当前节点弹出添加到列表中，将节点的子节点值加入到队列中
                TreeNode poll = queue.poll();
                list.add(poll.val);
                //先左后右
                if(poll.left != null){
                    queue.offer(poll.left);
                    c2++;
                }
                if(poll.right != null){
                    queue.offer(poll.right);
                    c2++;
                }
            }
            //for循环结束，队列中只有下一层的节点，继续遍历下一层的节点
            //修改for循环终止条件
            c1 = c2;
            //将每一层的结果添加到结果集
            res.add(list);
        }

    }
}
