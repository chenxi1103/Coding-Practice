public class Solution {
    /**
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     * 又是一个动态规划题，图论题，和之前的最小和路径非常像，就是把第一行和第一列都改成1就对了
     * 要复习！
     * oct.28 5:56pm
     */
    public int uniquePaths(int m, int n) {
        // write your code here
        if(m == 1 || n == 1) return 1;
        int[][] sum = new int[m][n];
        for(int i = 0; i<m; i++){
            sum[i][0] = 1;
        }
        for(int j = 0; j<n; j++){
            sum[0][j] = 1;
        }
        for(int i = 1; i<m; i++){
            for(int j = 1; j<n; j++){
                sum[i][j] = sum[i-1][j]+sum[i][j-1];
            }
        }
        return sum[m-1][n-1];
    }
}
