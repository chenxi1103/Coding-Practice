//PriorityQueue和Hashset的结合，记住！你虽然pq里加了很多东西，但是poll出来的永远是最小值，而且你只poll了n-1个！！！
public class Solution {
    /**
     * @param n: An integer
     * @return: return a  integer as description.
     */
    public int nthUglyNumber(int n) {
        // write your code here
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        long[] primers = new long[3];
        primers[0] = Long.valueOf(2);
        primers[1] = Long.valueOf(3);
        primers[2] = Long.valueOf(5);
        for(int i = 0; i < primers.length; i++){
            pq.add(primers[i]);
            set.add(primers[i]);
        }
        long result = 1;
        for(int i = 1; i < n; i++){
            result = pq.poll();
            for(int j = 0; j < primers.length; j++){
                if(!set.contains(primers[j] * result)){
                    set.add(primers[j] * result);
                    pq.offer(primers[j] * result);
                }
            }
        }
        return (int)result;
    }
}
