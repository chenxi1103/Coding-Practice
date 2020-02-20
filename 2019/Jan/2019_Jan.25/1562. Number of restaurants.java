// 亚麻 3
// 用heap排序真的很好用诶
// 如果把distance存在array里后用Arrays.sort来排序的话，时间复杂度是o(nlogn) -> 因为Arrays.sort用的算法是快排
// 同理，如果用Collections.sort，时间复杂度是o(nlogn) -> 因为Collections.sort用的是归并排序
// 如果用heap排序时间复杂度就是o(logn)了，速度会快一些。
public class Solution {
    /**
     * @param restaurant:
     * @param n:
     * @return: nothing
     */
    class Point implements Comparable<Point>{
        int distance;
        public Point(int distance) {
            this.distance = distance;
        }
        @Override
        public int compareTo(Point o) {
            int diff = o.distance - this.distance;
            return diff;
        }
    }
    public List<List<Integer>> nearestRestaurant(List<List<Integer>> restaurant, int n) {
        // Write your code here
        if(restaurant == null || restaurant.size() == 0 || restaurant.size() < n) return new ArrayList<>();
        if(restaurant.size() == n) return restaurant;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < restaurant.size(); i++) {
            int distance = restaurant.get(i).get(0) * restaurant.get(i).get(0)
                        + restaurant.get(i).get(1) * restaurant.get(i).get(1);
            Point currPoint = new Point(distance);
            pq.offer(currPoint);
            while(pq.size() > n) {
                pq.poll();
            }
        }
        int maxDistance = pq.poll().distance;
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < restaurant.size(); i++) {
            if(result.size() == n) break;
            int distance = restaurant.get(i).get(0) * restaurant.get(i).get(0)
                        + restaurant.get(i).get(1) * restaurant.get(i).get(1);
            if(distance <= maxDistance) {
                result.add(restaurant.get(i));
            }
        }
        return result;
    }
}
