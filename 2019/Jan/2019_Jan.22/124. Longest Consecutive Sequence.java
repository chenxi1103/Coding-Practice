public class Solution {
    /**
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] num) {
        // write your code here
        if(num == null || num.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(num);
        int maxKey = num[0];
        int maxValue = 1;
        for(int i = 0; i < num.length; i++){
            if(!map.containsKey(num[i] - 1)){
                map.put(num[i], 1);
            }else{
                map.put(num[i], map.get(num[i] - 1) + 1);
                if(map.get(num[i]) > maxValue){
                    maxValue = map.get(num[i]);
                    maxKey = num[i];
                }
            }
        }
        return maxValue;
    }
}
