class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        int[][] mincost = new int[costs.length][costs[0].length];
        mincost[0][0] = costs[0][0];
        mincost[0][1] = costs[0][1];
        mincost[0][2] = costs[0][2];

        for (int i = 1; i < mincost.length; i++) {
            mincost[i][0] = Math.min(mincost[i-1][1], mincost[i-1][2]) + costs[i][0];
            mincost[i][1] = Math.min(mincost[i-1][0], mincost[i-1][2]) + costs[i][1];
            mincost[i][2] = Math.min(mincost[i-1][0], mincost[i-1][1]) + costs[i][2];
        }
        return Math.min(mincost[mincost.length - 1][0], Math.min(mincost[mincost.length - 1][1], mincost[mincost.length - 1][2]));
    }
}
