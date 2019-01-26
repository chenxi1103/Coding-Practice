//亚麻2
public class Solution {
    /**
     * @param stringIn: The original string.
     * @param K: The length of substrings.
     * @return: return the count of substring of length K and exactly K distinct characters.
     */
    public int KSubstring(String stringIn, int K) {
        // Write your code here
        HashSet<Character> set = new HashSet<>();
        HashSet<String> strs = new HashSet<>();
        int start = 0;
        for(int i = 0; i < stringIn.length(); i++){
          //这个处理很重要！！！
            while(set.contains(stringIn.charAt(i))) {
                set.remove(stringIn.charAt(start++));
            }
            set.add(stringIn.charAt(i));
            if(set.size() == K){
                String currStr = stringIn.substring(start, start + K);
                if(!strs.contains(currStr)){
                    strs.add(currStr);
                }
                set.remove(stringIn.charAt(start++));
            }
        }
        return strs.size();
    }
}
