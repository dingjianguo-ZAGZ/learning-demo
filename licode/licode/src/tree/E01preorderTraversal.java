package tree;

import java.util.ArrayList;
import java.util.List;

public class E01preorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        addF(root,res);
        return res;

    }
    public void addF(TreeNode root,List res){
        if(root == null){
            return ;
        }
        res.add(root.val);
        addF(root.left,res);
        addF(root.right,res);
    }
}
