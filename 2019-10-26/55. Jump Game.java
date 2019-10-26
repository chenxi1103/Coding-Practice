class Solution {
    public boolean canJump(int[] nums) {
        boolean[] canjump = new boolean[nums.length];
        canjump[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
              //这一步判断比较重要，j (第j步) + nums[j](在这一步能跳的步数) >= i (第i步)
                if (canjump[j] && j + nums[j] >= i) canjump[i] = true;
            }
        }
        return canjump[canjump.length-1];
    }
}
