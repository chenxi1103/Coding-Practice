//气死老子了…不要想当然认为第一个数一定是负数，如果正数比负数多的时候，正数是第一个！！！
public class Solution {
    /*
     * @param A: An integer array.
     * @return: nothing
     */
    public void rerange(int[] A) {
        // write your code here
        if(A == null || A.length <=1) return;
        int[] neg = new int[1 + A.length / 2];
        int[] pos = new int[1 + A.length / 2];
        int n = 0, p = 0;
        for(int i = 0; i<A.length; i++){
            if(A[i] < 0){
                neg[n++] = A[i];
            }else{
                pos[p++] = A[i];
            }
        }
        if(n < p){
            helper(A, pos, neg);
        }else{
            helper(A, neg, pos);
        }
        return;
    }
    private void helper(int[] A, int[] B, int[] C){
        for(int i = 0; i<C.length - 1; i++){
            A[i*2] = B[i];
            A[i*2+1] = C[i];
        }
        if(A.length % 2 == 1) A[A.length - 1] = B[B.length - 1];
        return;
    }
}
