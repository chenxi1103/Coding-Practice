//图的遍历，如果不用recursion的话，要把x和y坐标都压进queue里，然后遍历过的记得做好记号。
public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j]){
                    grid[i][j] = false;
                    count++;
                    markByBfs(grid, i, j);
                }
            }
        }
        return count;
    }
    private void markByBfs(boolean[][] grid, int i, int j){
        int[] x_dir = {0, 1, -1, 0};
        int[] y_dir = {1, 0, 0, -1};
        Queue<Integer> queue_x = new LinkedList<>();
        Queue<Integer> queue_y = new LinkedList<>();
        queue_x.offer(i);
        queue_y.offer(j);
        while(!queue_x.isEmpty()){
            int curr_x = queue_x.poll();
            int curr_y = queue_y.poll();
            for(int k = 0; k<4; k++){
                int newX = curr_x+x_dir[k];
                int newY =  curr_y+y_dir[k];
                if(newX >= 0 && newX <= grid.length - 1 && newY >= 0 && newY <= grid[0].length - 1){
                    if(grid[newX][newY] == true){
                        queue_x.offer(newX);
                        queue_y.offer(newY);
                        grid[newX][newY] = false;
                    }
                }
            }
        }
        return;
    }
}
