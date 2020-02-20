class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeTree(nums, 0, nums.length - 1);
    }
    private TreeNode makeTree(int[] nums, int left, int right) {
        if(left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode l = makeTree(nums, left, mid - 1);
        TreeNode r = makeTree(nums, mid+1, right);
        root.left = l;
        root.right = r;
        return root;
    }
}
