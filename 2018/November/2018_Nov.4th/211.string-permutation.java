public class Solution {
    /**
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     * 和之前的一道题一样，用ascii码开一个256的array，一个加一个-
     * Nov.4th 1:18pm
     */
    public boolean Permutation(String A, String B) {
        // write your code here
        if(A.length()!=B.length()) return false;
        int[] ascii = new int[256];
        for(int i = 0; i<A.length();i++){
            ascii[A.charAt(i)]++;
        }
        for(int i = 0; i<B.length();i++){
            if(ascii[B.charAt(i)] == 0) return false;
            ascii[B.charAt(i)]--;
        }
        for(int i = 0; i<256; i++){
            if(ascii[i]!=0) return false;
        }
        return true;
    }
}
