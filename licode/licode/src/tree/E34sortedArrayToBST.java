package tree;

public class E34sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return BuildTree(nums,0,nums.length-1);
    }
    public TreeNode BuildTree(int[] nums,int low,int high){
        if(low > high){
            return null;
        }
        int index = low + (high - low)/2;
        TreeNode root = new TreeNode(nums[index]);
        root.left = BuildTree(nums,low,index-1);
        root.right = BuildTree(nums,index+1,high);
        return root;
    }
}
