/**
 * Given an array of strings, group anagrams together.
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3288/
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortStr = String.valueOf(charArray);
            if (map.containsKey(sortStr)) {
                map.get(sortStr).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortStr, list);
            }
        }
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
}