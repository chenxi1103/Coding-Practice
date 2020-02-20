public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if (s == null || s.length() == 0 || k == 0) return 0;
        if (s.length() <= k) return s.length();
        int start = 0, result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
            if(map.size() > k) {
                if(result < i - start) result = i - start;
                while(map.size() > k) {
                    int count = map.get(s.charAt(start)) - 1;
                    if(count == 0) {
                        map.remove(s.charAt(start));
                    } else {
                        map.put(s.charAt(start), count);
                    }
                    start++;
                }
            }
        }
        return Math.max(result, s.length() - start);
    }
}
