// 这是一道反向dp题，从终点往起点推，要始终保证骑士所在的位置生命值大于等于1
// 方法是在边界上由于只能向左走或者向上走，所以比较前一个点到这个点后的值 和 1.
// 中间部分比较是向左走比较好还是向上走比较好，然后选一个点后再与1相比较
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] result = new int[dungeon.length][dungeon[0].length];
        int m = dungeon.length - 1;
        int n = dungeon[0].length - 1;
        result[m][n] = Math.max(1 - dungeon[m][n], 1);
        for(int i = m - 1; i >= 0; i--) {
            result[i][n] = Math.max(result[i+1][n] - dungeon[i][n], 1);
        }
        for(int i = n - 1; i >= 0; i--) {
            result[m][i] = Math.max(result[m][i+1] - dungeon[m][i], 1);
        }
        for(int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                result[i][j] = Math.min(result[i+1][j], result[i][j+1]);
                result[i][j] = Math.max(result[i][j] - dungeon[i][j], 1);
            }
        }
        return result[0][0];
    }
}
