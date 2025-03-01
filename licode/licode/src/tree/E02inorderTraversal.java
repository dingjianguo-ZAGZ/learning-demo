package tree;

import java.util.ArrayList;
import java.util.List;

public class E02inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        addM(root,res);
        return res;
    }
    public void addM(TreeNode root,List res){
        if(root == null){
            return;
        }
        addM(root.left,res);
        res.add(root.val);
        addM(root.right,res);
    }

}
