package tree;

public class E042sortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return binaryToBST(0,nums.length,nums);

    }
    public TreeNode binaryToBST(int left,int right,int[] nums){
        if(left > right){
            return null;
        }
        int mid = (left + right)/2;
        int val = nums[mid];
        //根节点
        TreeNode root = new TreeNode(val);
        root.left= binaryToBST(left, mid - 1, nums);
        root.right = binaryToBST(mid+1,right,nums);
        return root;
    }
}
