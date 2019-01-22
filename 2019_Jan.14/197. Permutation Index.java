//利用某种数学性质写出来的，记得不要忘了
public class Solution {
    /**
     * @param A: An array of integers
     * @return: A long integer
     */
    public long permutationIndex(int[] A) {
        // write your code here
        long result = 1;
        if(A.length <= 1) return result;
        for(int i = 0; i < A.length; i++){
            int count = 0;
            for(int j = i+1; j < A.length; j++){
                if(A[i] > A[j]) count++;
            }
            result = result + factorial(A.length - 1 - i) * count;
        }
        return result;
    }
    private long factorial(int a){
        long result = 1;
        if(a == 0) return result;
        while(a > 0){
            result = result * a;
            a--;
        }
        return result;
    }
}
