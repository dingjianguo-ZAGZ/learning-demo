package tree;

import java.util.ArrayList;
import java.util.List;

public class E17binaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return null;
        }
        List<Integer> paths = new ArrayList<>();
        List<String> res = new ArrayList<>();
        getPath(root,paths,res);
        return res;

    }
    public void getPath(TreeNode node,List paths,List<String> res){
        paths.add(node.val);//前序遍历
        if(node.left==null && node.right == null){//叶子节点
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size()-1; i++) {
                sb.append(paths.get(i) + "->");
            }
            sb.append(paths.get(paths.size()-1));
            res.add(sb.toString());
        }
        if(node.left != null){
            getPath(node.left,paths,res);
            //回溯
            paths.remove(paths.size()-1);
        }
        if(node.right != null){
            getPath(node.right,paths,res);
            //回溯
            paths.remove(paths.size()-1);
        }
    }
}
