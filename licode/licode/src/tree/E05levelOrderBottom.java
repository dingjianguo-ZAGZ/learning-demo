package tree;

import java.util.*;

public class E05levelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();
        if(root == null){
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> inner = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                inner.add(poll.val);
                if(poll.left != null){
                    queue.offer(poll.left);
                }
                if(poll.right!= null){
                    queue.offer(poll.right);
                }
            }
            stack.push(inner);
        }
        while (!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }
}
