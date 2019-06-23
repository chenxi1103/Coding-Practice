// 看到乱序排序，可以想到用堆来解决
// priorityqueue只是heap的一种实现方式（二叉堆），还可以有其他实现方式，比如斐波那契堆

// 二维上的最小k，更偏graph的问题，一做graph的题应该很自然的想到新建一个class来存两个坐标点和该坐标点上的值
// 应很自然的想到新建一个boolean二维数组来记录遍历过的点防止重复遍历
// 再结合priorityqueue的二叉堆排序，可以顺利解出这道题。

public class Solution {
    class Point {
        int firstIndex;
        int secondIndex;
        int val;
        public Point (int firstIndex, int secondIndex, int val) {
            this.firstIndex = firstIndex;
            this.secondIndex = secondIndex;
            this.val = val;
        }
    }

    class PointComparator implements Comparator<Point> {
        @Override
        public int compare(Point a, Point b) {
            return a.val - b.val;
        }
    }

    /**
     * @param matrix: a matrix of integers
     * @param k: An integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        PriorityQueue<Point> queue = new PriorityQueue<Point>(k, new PointComparator());
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        queue.add(new Point(0, 0, matrix[0][0]));
        visited[0][0] = true;
        int counter = 1;
        while (counter < k) {
            Point currMinPoint = queue.poll();
            int x = currMinPoint.firstIndex;
            int y = currMinPoint.secondIndex;
            if (x < matrix.length - 1 && !visited[x+1][y]) {
                queue.add(new Point(x+1, y, matrix[x+1][y]));
                visited[x+1][y] = true;
            }
            if (y < matrix[0].length - 1 && !visited[x][y+1]) {
                queue.add(new Point(x, y+1, matrix[x][y+1]));
                visited[x][y+1] = true;
            }
            counter++;
        }
        return queue.peek().val;
    }
}
