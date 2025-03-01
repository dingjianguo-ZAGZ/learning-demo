package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class E06rightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        dfs(root,0,res);
        return res;

    }
    private void dfs(TreeNode node,int depth,List res){
        if(node == null){
            return;
        }
        //每一层一定有一个元素放入集合中
        //如果层数（从0开始）等于集合中元素的个数，说明这是开始的新的一层
        if(res.size() == depth){
            res.add(node.val);
        }
        dfs(node.right,depth+1,res);
        dfs(node.left,depth+1,res);
    }
}
