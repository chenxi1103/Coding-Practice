public class Solution {
    /**
     * @param s: a string
     * @param excludewords: a dict
     * @return: the most frequent word
     */
    public String frequentWord(String s, Set<String> excludewords) {
        // Write your code here
        String[] strs = s.split(" ");
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < strs.length; i++) {
            if(!Character.isLetter(strs[i].charAt(strs[i].length() - 1))) {
                strs[i] = strs[i].substring(0, strs[i].length() - 1);
            }
            if(!excludewords.contains(strs[i])) {
                if(!map.containsKey(strs[i])) {
                    map.put(strs[i], 1);
                } else{
                    map.put(strs[i], map.get(strs[i]) + 1);
                }
            }
        }
        int max = 0;
        String result = "";
        for(String str : map.keySet()) {
            if(map.get(str) == max && isSmallerLexicographic(str, result)) {
                result = str;
            }
            if(map.get(str) > max) {
                max = map.get(str);
                result = str;
            }
        }
        return result;
    }

    private boolean isSmallerLexicographic(String str1, String str2) {
        int size = str1.length() < str2.length() ? str1.length() : str2.length();
        for(int i = 0; i < size; i++) {
            if (str1.charAt(i) < str2.charAt(i)) return true;
            else if(str1.charAt(i) > str2.charAt(i)) return false;
            else continue;
        }
        if(str1.length() < str2.length()) return true;
        return false;
    }
}
