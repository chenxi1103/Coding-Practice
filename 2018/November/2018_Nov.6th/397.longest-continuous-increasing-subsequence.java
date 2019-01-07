public class Solution {
    /**
     * @param A: An array of Integer
     * @return: an integer
     * 重点：起始count是2！！！因为一开始就拿着两个数做比较的！
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
        if(A == null || A.length ==0) return 0;
        if(A.length == 1) return 1;
        int max = 1;
        int count = 2;
        int flag = A[1] - A[0];
        for(int i = 1; i<A.length-1; i++){
            int temp = A[i+1] - A[i];
            if(temp*flag > 0) {
                count++;
                continue;
            }
            flag = temp;
            max = Math.max(max, count);
            count = 2;
        }
        max = Math.max(max, count);
        return max;
    }
}
