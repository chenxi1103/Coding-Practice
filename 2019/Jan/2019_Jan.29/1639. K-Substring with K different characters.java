public class Solution {
    /**
     * @param stringIn: The original string.
     * @param K: The length of substrings.
     * @return: return the count of substring of length K and exactly K distinct characters.
     */
    public int KSubstring(String stringIn, int K) {
        // Write your code here
        HashSet<Character> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        int index = 0;
        for(int i = 0; i < stringIn.length(); i++) {
            while(set1.contains(stringIn.charAt(i))) {
                set1.remove(stringIn.charAt(index++));
            }
            set1.add(stringIn.charAt(i));
            if(set1.size() == K) {
                String currStr = stringIn.substring(index, index + K);
                if(!set2.contains(currStr)) {
                    set2.add(currStr);
                }
                set1.remove(stringIn.charAt(index++));
            }
        }
        return set2.size();
    }
}
