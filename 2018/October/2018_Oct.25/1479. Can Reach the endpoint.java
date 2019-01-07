public class Solution {
    /**
     * @param map: the map
     * @return: can you reach the endpoint
     * 又是经典的图论题，图的遍历一般用到bfs或者dfs。区别是：
     * bfs：寻找最优解，有最优解就停止，需要额外空间记录
     * dfs：寻找所有解，不需要额外空间记录
     * 这道题显然是用dfs好一些，因为我们不需要找到到9的最短距离，而是找能不能到达9，所以
     * 就要遍历所有图直到找到能到达9的解，然后停止。
     * 时间：2018-10-25 1:25pm
     */
    public boolean reachEndpoint(int[][] map) {
        // Write your code here
        return dfs(map,0,0);
    }
    public boolean dfs(int[][] map, int i, int j){
        if(i>=map.length||j>=map[0].length||map[i][j] == 0) return false;
        if(map[i][j] == 9) return true;
        map[i][j] = 0;
        return dfs(map,i+1,j) || dfs(map,i,j+1);
    }
}
