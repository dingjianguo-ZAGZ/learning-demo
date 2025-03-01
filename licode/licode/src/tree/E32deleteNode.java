package tree;

public class E32deleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(root.val == key){//是要删除的节点
            //判断节点状态
            //1.节点只有右孩子或者没有孩子 -> 将右边的有序结构拼接上删除当前节点
            if(root.left == null ||(root.left == null && root.right == null)){
                return root.right;
            }
            //2.节点只有左孩子 -> 将左边的有序结构拼接上删除当前节点
            if(root.right == null){
                return root.left;
            }
            //3.既有左孩子，又有右孩子 -> 将左边的有序架构拼接在右孩子的最小节点上
            if(root.left != null && root.right != null){
                //找右孩子的最小节点
                TreeNode s = root.right;
                while (s.left != null){
                    s = s.left;
                }
                //循环结束后,s.left == null,说明 s 是最小节点
                //将左边的有序结构拼接
                s.left = root.left;
                //删除当前节点
                return root.right;
            }
        }
        root.left = deleteNode(root.left,key);
        root.right = deleteNode(root.right,key);
        return root;
    }
}
