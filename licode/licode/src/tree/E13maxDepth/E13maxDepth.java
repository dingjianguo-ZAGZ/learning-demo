package tree.E13maxDepth;

import java.util.List;

public class E13maxDepth {
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        List<Node> nodes = root.children;
        int depth = 0;
        for (Node node : nodes) {
            depth = Math.max(maxDepth(node),depth);
        }
        return depth+1;
    }
}
