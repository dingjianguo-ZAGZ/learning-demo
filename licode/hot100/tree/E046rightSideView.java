package tree;

import java.util.*;

public class E046rightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //层序遍历，加入每一层的最右节点
        Deque<TreeNode> deque = new LinkedList<>();
        if(root == null){
            return res;
        }
        TreeNode node = root;
        deque.offer(node);
        while (!deque.isEmpty()){
            int size = deque.size();//表示这一层有多少个元素
            for (int i = 0; i < size; i++) {
                TreeNode pollFirst = deque.poll();
                //将这一层每个元素的孩子节点加入队列
                if(pollFirst.left != null){
                    deque.offer(pollFirst.left);
                }
                if(pollFirst.right != null){
                    deque.offer(pollFirst.right);
                }
                if(i == size-1){
                    //这一层的最后一个元素加入结果集
                    res.add(pollFirst.val);
                }
            }
        }
        return res;
    }
}
