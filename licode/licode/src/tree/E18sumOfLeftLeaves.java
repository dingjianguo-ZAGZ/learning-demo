package tree;

import com.sun.nio.file.ExtendedWatchEventModifier;

import java.awt.image.renderable.RenderableImage;
import java.util.logging.Level;

public class E18sumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
    /*
        递归的终止条件 ： 1. 如果当前节点为null，返回0
                       3. 如果当前节点的左孩子为左叶子节点，记录左叶子的值
    */
        if (root == null) {
            return 0;
        }
        int mid = 0;
        // 当前遍历到的节点的左孩子为左叶子节点
        if (root.left != null && root.left.left == null && root.left.right == null) {
            // 记录左叶子的值
            mid = root.left.val;
        }
        // 递归求左孩子的左叶子之和
        int left = sumOfLeftLeaves(root.left);
        // 右孩子的左叶子之和
        int right = sumOfLeftLeaves(root.right);

        // 返回左叶子的值+左孩子的左叶子之和+右孩子的左叶子之和
        return mid + left + right;
    }
}
