//这道题的trick是，每当拿到一个质数后，可知质数的倍数一定不是质数，
//把这些位置都填上1，这样剩下的0就是质数的位置
public class Solution {
    /**
     * @param n: a integer
     * @return: return a integer
     */
    public int countPrimes(int n) {
        // write your code here
        if(n <= 2) return 0;
        boolean[] record = new boolean[n];
        int count = 0;
        for(int i = 2; i < n; i++) {
            if(!record[i]) {
                count++;
                for(int times = 1; times * i < n; times++) {
                    record[times * i] = true;
                }
            }
        }
        return count;
    }
}
