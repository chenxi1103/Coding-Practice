class Solution {
    public int uniquePaths(int m, int n) {
        int[][] record = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    record[i][j] = 1;
                    continue;
                }
                record[i][j] = record[i-1][j] + record[i][j-1];
            }
        }
        return record[m-1][n-1];
    }
}
