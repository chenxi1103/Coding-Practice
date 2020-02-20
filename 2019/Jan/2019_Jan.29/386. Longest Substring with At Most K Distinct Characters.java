// 很难一次性写对，好烦
public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if(s == null || s.length() == 0 || k == 0) return 0;
        if(s.length() <= k) return s.length();
        int result = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        int index = 0;
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
            if(map.size() > k) {
                if(i - index > result) {
                    result = i - index;
                }
                while(map.size() > k) {
                    int count = map.get(s.charAt(index)) - 1;
                    if(count == 0) {
                        map.remove(s.charAt(index));
                    } else {
                        map.put(s.charAt(index), count);
                    }
                    index++;
                }
            }
        }
        return Math.max(result, s.length() - index);
    }
}
