/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param A:
     * @param query:
     * @return: nothing
     */
    public List<Integer> intervalXOR(int[] A, List<Interval> query) {
        //
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i<query.size(); i++){
            int start = query.get(i).start;
            int xor = A[start];
            for(int j = start+1; j<start+2; j++){
                xor = xor^A[j];
            }
            result.add(xor);
        }
        return result;
    }
}
