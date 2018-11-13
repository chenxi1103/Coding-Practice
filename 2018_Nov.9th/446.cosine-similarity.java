public class Solution {
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: Cosine similarity
     * 简单，没什么好说的
     */
    public double cosineSimilarity(int[] A, int[] B) {
        // write your code here
        if(A == null || B == null || A.length != B.length) return (double) 2;
        int Asum = 0, Bsum = 0, sum = 0;
        for(int i = 0; i < A.length; i++){
            sum += A[i]*B[i];
            Asum += A[i]*A[i];
            Bsum += B[i]*B[i];
        }
        if(Asum == 0 || Bsum == 0) return (double) 2;
        return sum/(Math.pow(Asum,0.5)*Math.pow(Bsum,0.5));
    }
}
