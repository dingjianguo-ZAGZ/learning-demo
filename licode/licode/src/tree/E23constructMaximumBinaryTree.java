package tree;

public class E23constructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return foundTree(nums,0,nums.length);
    }
    public TreeNode foundTree(int[] nums,int begin,int end){
        if(begin >= end){
            return null;
        }
        int max = -1;
        int maxIndex = 0;
        for (int i = begin; i < end; i++) {
            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = foundTree(nums,begin,maxIndex);
        root.right = foundTree(nums,maxIndex+1,end);
        return root;
    }

}
