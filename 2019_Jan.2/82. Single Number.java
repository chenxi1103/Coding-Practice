public class Solution {
    /**
     * @param A: An integer array
     * @return: An integer
     * 这个题要活用抑或函数！！！第一个版本是不用抑或函数的版本
     */
    public int singleNumber(int[] A) {
        // write your code here
        if(A == null || A.length == 0) return -1;
        Arrays.sort(A);
        int result = -1;
        for(int i = 0; i<A.length-1; i++){
            if(A[i] == A[i+1]){
                i++;
            }else{
                result = A[i];
            }
        }
        if(result == -1) result = A[A.length-1];
        return result;
    }
}

//////////////////抑或函数版本///////////////////////
public class Solution {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumber(int[] A) {
        // write your code here
        if(A == null || A.length == 0) return -1;
        int result = 0;
        for(int i = 0; i<A.length; i++){
            result ^= A[i];
        }
        return result;
    }
}
