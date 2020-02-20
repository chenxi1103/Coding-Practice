public class Solution {
    /**
     * @param n: The number of digits
     * @return: All narcissistic numbers with n digits
     * 水仙花数，记得写一个helper function pow
     */
    public List<Integer> getNarcissisticNumbers(int n) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        if(n == 1){
            for(int i = 0; i<10; i++){
                result.add(i);
            }
            return result;
        }
        if(n == 2){
            return result;
        }
        for(int i = pow(10, n-1); i<pow(10,n); i++){
            int sum = 0;
            int k = i;
            for(int j = 0; j<n; j++){
                sum += pow(k%10, n);
                k = k / 10;
            }
            if(sum == i) result.add(i);
        }
        return result;
    }
    private int pow(int a, int b){
        int result = 1;
        for(int i = 0; i<b; i++){
            result = result * a;
        }
        return result;
    }
}
