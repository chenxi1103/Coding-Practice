class NumArray {

    public int[] cloneNums;
    public NumArray(int[] nums) {
        cloneNums = new int[nums.length];
        cloneNums[0] = nums[0];
        for(int i = 1; i<nums.length; i++){
            cloneNums[i] = cloneNums[i-1]+nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return
    }
}
