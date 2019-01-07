public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     * 用动态规划做的经典题目，但是因为还不太明白动态规划是啥，所以以后还要复习
     * 思路是：走上第n阶台阶的方法数等于走上第n-1阶台阶的方法+n-2阶台阶的方法
     * Oct.28 5:33pm
     */
    public int climbStairs(int n) {
        // write your code here
        if(n<=1) return n;
        int[] list = new int[n+1];
        list[0] = 1;
        list[1] = 1;
        for(int i = 2; i<=n; i++){
            list[i] = list[i-2]+list[i-1];
        }
        return list[n];
    }
}
