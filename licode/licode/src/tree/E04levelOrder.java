package tree;

import java.util.*;

public class E04levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> inner = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode pollTree = queue.poll();
                inner.add(pollTree.val);
                //把他的孩子节点放入队列
                if(pollTree.left != null){
                    queue.offer(pollTree.left);
                }
                if(pollTree.right != null){
                    queue.offer(pollTree.right);
                }
            }
            res.add(inner);
        }
        return res;

    }


}
