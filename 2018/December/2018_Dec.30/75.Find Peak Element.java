public class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
     //感觉和找山岭数列没什么太大区别，可以从1和length-2开始找因为mid不会出现在0和length-1
    public int findPeak(int[] A) {
        // write your code here
        if(A.length == 3) return 1;
        int start = 1, end = A.length - 2;
        while(start+1<end){
            int mid = start + (end - start) / 2;
            if(A[mid-1]<A[mid] && A[mid+1] < A[mid]) return mid;
            else if(A[mid-1] > A[mid]) end = mid;
            else start = mid;
        }
        return A[start] > A[end] ? start : end;
    }
}
