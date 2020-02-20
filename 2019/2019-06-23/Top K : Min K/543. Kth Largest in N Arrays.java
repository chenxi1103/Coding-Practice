//这是一道hard题，和401的区别就是，这个matrix不存在横竖递增的条件了，而且matrix里也不一定是
//长度相同的array组成的，有的甚至可能是空array。
// 所以想把hard变成medium，第一步就是对每一个array都排序，让它变成有序的array
// 然后把每个array里最大的数先加进去，然后priorityqueue会自动排序出最大的那个数，然后
// 再从当前最大数所在的array里，拿第二大的数，以此类推。

// 时间复杂度是m*n*log(n)
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
            return b.val - a.val;
        }
    }
    /**
     * @param arrays: a list of array
     * @param k: An integer
     * @return: an integer, K-th largest element in N arrays
     */
    public int KthInArrays(int[][] arrays, int k) {
        // write your code here
        PriorityQueue<Point> queue = new PriorityQueue<Point>(k, new PointComparator());
        for (int i = 0; i < arrays.length; i++) {
            Arrays.sort(arrays[i]);
            if (arrays[i].length > 0) {
                queue.add(new Point(i, arrays[i].length - 1, arrays[i][arrays[i].length - 1]));
            }
        }
        while (k > 1) {
            Point currPoint = queue.poll();
            int x = currPoint.firstIndex;
            int y = currPoint.secondIndex;
            if (y > 0) {
                queue.add(new Point(x, y-1, arrays[x][y-1]));
            }
            k--;
        }
        return queue.peek().val;
    }
}
