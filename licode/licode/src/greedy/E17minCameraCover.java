package greedy;

public class E17minCameraCover {
    int res = 0;
    public int minCameraCover(TreeNode root) {
        int rootCamera = minCamera(root);
        //如果根节点没有被覆盖，加一个摄像头
        if(rootCamera == 0){
            res++;
        }
        return res;
    }
    public int minCamera(TreeNode root){
        // 0 表示无覆盖 1 表示有摄像头 2 表示有覆盖
        if(root == null){
            //节点为空，不能装摄像头，也不能影响数量，设置为有覆盖
            return 2;
        }
        int left = minCamera(root.left);
        int right = minCamera(root.right);
        if(left == 2 && right == 2){
            //左右节点都有覆盖，则父节点没有被覆盖，没有摄像头
            return 0;
        }else if(left == 0 || right == 0){
            //左右有一个未覆盖，需要在父节点装摄像头
            res++;
            return 1;
        }else {
            //其余情况，左右节点有一个有摄像头，则本节点被覆盖
            return 2;
        }
    }
}
