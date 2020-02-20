public class Solution {
    /**
     * @param L: an integer
     * @param R: an integer
     * @return: the count of numbers in the range [L, R] having a prime number of set bits in their binary representation
     */
    public int countPrimeSetBits(int L, int R) {
        // Write your code here
        int result = 0;
        for(int i = L; i <= R; i++) {
            int bits = countBit(i);
            if(isPrime(bits)) result++;
        }
        return result;
    }
    private int countBit(int A) {
        if(A == 0) return 0;
        int count = 0;
        while (A != 0) {
          //关键是这一步，希望做完datalab可以有很好的理解
            A = A & (A-1);
            count++;
        }
        return count;
    }
    private boolean isPrime(int A) {
        if(A < 2) return false;
        else if(A == 2) return true;
        for(int i = 2; i * i <= A; i++) {
            if(A % i == 0) return false;
        }
        return true;
    }
}
