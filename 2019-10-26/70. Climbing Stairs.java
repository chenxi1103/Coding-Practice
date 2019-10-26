class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] ways = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if (i <= 2) ways[i] = i;
            else ways[i] = ways[i-1] + ways[i-2];
        }
        return ways[n];
    }
}
