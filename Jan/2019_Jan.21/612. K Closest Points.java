//用prioirtyqueue！！！只需要复写priorityqueue的compare方法，就可以每次插入都保持sort的状态！！！太厉害了
public class Solution {
    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    private Point originalPoint;
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
        originalPoint = origin;
        PriorityQueue<Point> queue = new PriorityQueue<Point>(k, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2){
                int diff = 0;
                diff = getDistance(originalPoint, p2) - getDistance(originalPoint, p1);
                if(diff == 0){
                    diff = p2.x - p1.x;
                }
                if(diff == 0){
                    diff = p2.y - p1.y;
                }
                return diff;
            }
        });

        for(int i = 0; i < points.length; i++){
            queue.offer(points[i]);
            if(queue.size() > k){
                queue.poll();
            }
        }
        Point[] result = new Point[k];
        for(int i = k-1; i >= 0; i--){
            result[i] = queue.poll();
        }
        return result;
    }

    private int getDistance(Point origin, Point point){
        return (origin.x - point.x) * (origin.x - point.x) + (origin.y - point.y) * (origin.y - point.y);
    }

}
/////////////////////////////////////自己写的蠢方法///////////////////////////////////////
public class Solution {
    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
        Point[] result = new Point[k];
        HashMap<Double, ArrayList<Point>> map = new HashMap<>();
        double[] distances = new double[points.length];
        for(int i = 0; i < points.length; i++){
            double distance = getDistance(origin, points[i]);
            distances[i] = distance;
            if(map.containsKey(distance)){
                ArrayList<Point> list = map.get(distance);
                boolean flag = true;
                for(int j = 0; j < list.size(); j++){
                    if(compareTwoPoints(points[i], list.get(j)) == 1){
                        list.add(j, points[i]);
                        flag = false;
                        break;
                    }
                }
                if(flag) list.add(points[i]);
                map.put(distance, list);
            }else{
                ArrayList<Point> list = new ArrayList<>();
                list.add(points[i]);
                map.put(distance, list);
            }
        }
        Arrays.sort(distances);
        distances = removeDuplicate(distances);
        int count = 0;
        int index = 0;
        while(count < k){
            ArrayList<Point> list = map.get(distances[index]);
            for(int i = 0; i<list.size(); i++){
                result[count++] = list.get(i);
                if(count == k) break;
            }
            if(count == k) break;
            index++;
        }
        return result;

    }
    private double[] removeDuplicate(double[] A){
        if(A == null || A.length <= 1) return A;
        int count = 0;
        for(int i = 1; i<A.length; i++){
            if(A[i] != A[count]){
                A[++count] = A[i];
            }
        }
        double[] result = new double[count+1];
        for(int i = 0; i < count+1; i++){
            result[i] = A[i];
        }
        return result;
    }
    private double getDistance(Point origin, Point point){
        double xDistance = Math.pow((origin.x - point.x), 2);
        double yDistance = Math.pow((origin.y - point.y), 2);
        return xDistance + yDistance;
    }

    private int compareTwoPoints(Point p1, Point p2){
        if(p1.x == p2.x){
            return p1.y < p2.y ? 1 : 2;
        }
        return p1.x < p2.x ? 1 : 2;
    }

}
