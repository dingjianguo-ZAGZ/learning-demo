package tree;

import java.util.ArrayList;
import java.util.List;

public class E03postorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        addL(root,res);
        return res;
    }
    public void addL(TreeNode root,List res){
        if(root == null){
            return;
        }
        addL(root.left,res);
        addL(root.right,res);
        res.add(root.val);
    }
}
