package tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 二叉树最近公共父节点
 */
public class E049lowestCommonAncestor {
    //保存子节点的值和父节点
    Map<Integer,TreeNode> parent = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //把所有节点的值 以及节点的父节点保存下来
        dfs(root);
        //寻找 p 节点的位置
        while (p != null){
            visited.add(p.val);
            //获取 p 节点的父节点，依次将 p 节点的父节点加入集合
            p = parent.get(p.val);
        }
        //寻找 q节点的位置，找到公共父节点
        while (q != null){
            //递归头
            if(visited.contains(q.val)){
                return q;
            }
            //寻找 q 节点的父节点
            q = parent.get(q.val);
        }
        return null;
    }
    public void dfs(TreeNode root){
        if(root.left != null){
            parent.put(root.left.val,root);
            dfs(root.left);
        }
        if(root.right != null){
            parent.put(root.right.val,root);
            dfs(root.right);
        }
    }
}
