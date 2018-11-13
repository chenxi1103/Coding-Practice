public class Solution {
    /**
     * @param s: A string
     * @return: the length of last word
     * 这个题也太简单了…
     */
    public int lengthOfLastWord(String s) {
        // write your code here
        s = s.trim();
        String[] dict = s.split(" ");
        if(dict.length == 0) return 0;
        String lastword = dict[dict.length-1];
        return lastword.toCharArray().length;
    }
}
