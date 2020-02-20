//开始学习动态规划
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] list = new int[amount + 1];
        for(int i = 1; i < amount + 1; i++) {
            list[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i == coins[j]) {
                    list[i] = 1;
                    break;
                }
                if (i - coins[j] > 0 && list[i - coins[j]] != Integer.MAX_VALUE) {
                    list[i] = Math.min(list[i], list[i - coins[j]] + 1);
                }
            }
        }
        return list[amount] == Integer.MAX_VALUE ? -1 : list[amount];
    }
}
