//同样是一道hard题，但是经过转换可以变成medium
//首先它要求两个sorted arrays的加和第k小是多少
//我们可以首先把所有加和求出来map成一个大小为int[A.length][B.length]的matrix，
//然后就又和二维数组求第k小的问题一毛一样了。就变成了medium！

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
     * @param A: an integer arrays sorted in ascending order
     * @param B: an integer arrays sorted in ascending order
     * @param k: An integer
     * @return: An integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // write your code here
        PriorityQueue<Point> queue = new PriorityQueue<Point>(k, new PointComparator());
        int[][] sumMap = new int[A.length][B.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                sumMap[i][j] = A[i] + B[j];
            }
            queue.add(new Point(i, 0, sumMap[i][0]));
        }
        while (k > 1) {
            Point currPoint = queue.poll();
            int x = currPoint.firstIndex;
            int y = currPoint.secondIndex;
            if (y < sumMap[0].length - 1) {
                queue.add(new Point(x, y+1, sumMap[x][y+1]));
            }
            k--;
        }
        return queue.peek().val;
    }
}
