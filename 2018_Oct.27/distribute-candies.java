public class Solution {
    /**
     * @param candies: a list of integers
     * @return: return a integer
     * 做的不够好，因为前面用了一个sort，时间复杂度会上升，以后考虑一下如何优化
     */
    public int distributeCandies(int[] candies) {
        // write your code here
        Arrays.sort(candies);
        int duplicateCount = 0;
        int prev = candies[0];
        int curr = candies[0];
        for(int i = 0; i<candies.length; i++){
            curr = candies[i];
            if(curr!=prev){
                prev = curr;
                duplicateCount++;
            }
        }
        duplicateCount++;
        if(duplicateCount > candies.length/2) return candies.length/2;
        return duplicateCount;
    }
}
