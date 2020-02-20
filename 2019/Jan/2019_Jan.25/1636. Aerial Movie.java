public class Solution {
    /**
     * @param t: the length of the flight
     * @param dur: the length of movies
     * @return: output the lengths of two movies
     */
    public int[] aerial_Movie(int t, int[] dur) {
        // Write your code here
        t = t - 30;
        int[] result = new int[2];
        Arrays.sort(dur);
        int start = 0, end = dur.length - 1;
        while (start < end) {
            int prev = result[0] + result[1];
            int curr = dur[start] + dur[end];
            if (curr > t) {
                end--;
            }else{
                //这里不需要判断 curr == prev的情况因为prev的最大值一定比当前的最大值大（排过序的）
                if (curr > prev) {
                    result[0] = dur[start];
                    result[1] = dur[end];
                }
                start++;
            }
        }
        return result;
    }
}
