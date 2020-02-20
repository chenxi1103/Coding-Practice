// 动态规划题，规律是f[n] = f[n-1] + f[n-2] + f[n-3]
// 用递归会超时间，不能用
public class Solution {
    /**
     * @param n: An integer
     * @return: An Integer
     */
    public int climbStairs2(int n) {
        // write your code here
        int[] f = new int[n+1];
        f[0] = 1;
        for(int i = 0; i < f.length; i++) {
            int j = i - 1;
            while(j >= 0 && j >= i - 3) {
                f[i] += f[j];
                j--;
            }
        }
        return f[n];
    }
}
