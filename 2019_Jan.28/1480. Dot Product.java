public class Solution {
    /**
     * @param A: an array
     * @param B: an array
     * @return: dot product of two array
     */
    public int dotProduct(int[] A, int[] B) {
        // Write your code here
        if (A == null || B == null
        || A.length == 0 || B.length == 0
        || A.length != B.length) return -1;
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            result += A[i] * B[i];
        }
        return result;
    }
}
