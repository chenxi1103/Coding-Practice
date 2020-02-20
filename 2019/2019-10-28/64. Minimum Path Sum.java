class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        // int[][] memo = new int[grid.length][grid[0].length];
        int[][] memo = new int[2][grid[0].length];
        memo[0][0] = grid[0][0];
        int old = 0;
        int now = 0;
        for (int i = 0; i < grid.length; i++) {
            old = now;
            now = 1 - old;
            for (int j = 0; j < grid[0].length; j++) {
                memo[now][j] = grid[i][j];
                if (i - 1 >= 0 && j - 1 >= 0) {
                    memo[now][j] += Math.min(memo[old][j], memo[now][j-1]);
                } else if(i - 1 >= 0) {
                    memo[now][j] += memo[old][j];
                } else if (j - 1 >= 0) {
                    memo[now][j] += memo[now][j-1];
                }
            }
        }
        return memo[now][grid[0].length - 1];
    }
}
