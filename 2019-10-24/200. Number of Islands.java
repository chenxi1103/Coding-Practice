class Solution {
    public int numIslands(char[][] grid) {
        int counter = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) return counter;

        int[] X_dir = new int[]{1,-1,0,0};
        int[] Y_dir = new int[]{0,0,-1,1};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    Queue<Integer> queue_x = new LinkedList<>();
                    Queue<Integer> queue_y = new LinkedList<>();
                    queue_x.add(i);
                    queue_y.add(j);
                    grid[i][j] = '0';
                    while (!queue_x.isEmpty()) {
                        int curr_x = queue_x.poll();
                        int curr_y = queue_y.poll();
                        for (int k = 0; k < 4; k++) {
                            int new_x = curr_x + X_dir[k];
                            int new_y = curr_y + Y_dir[k];
                            if (checkBoarder(grid, new_x, new_y) && grid[new_x][new_y] == '1') {
                                grid[new_x][new_y] = '0';
                                queue_x.add(new_x);
                                queue_y.add(new_y);
                            }
                        }
                    }
                    counter++;
                }
            }
        }
        return counter;
    }

    private boolean checkBoarder(char[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
