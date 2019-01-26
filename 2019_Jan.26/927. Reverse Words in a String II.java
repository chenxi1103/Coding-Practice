public class Solution {
    /**
     * @param str: a string
     * @return: return a string
     */
    public char[] reverseWords(char[] str) {
        // write your code here
        if(str == null || str.length == 0) return str;
        // 记住，把char直接转换成string的方法是String.valueOf()
        String s = String.valueOf(str);
        String[] strs = s.split(" ");
        int left = 0, right = strs.length - 1;
        while (left <= right) {
            String temp = strs[left];
            strs[left] = strs[right] + " ";
            strs[right] = temp + " ";
            left++;
            right--;
        }
        s = "";
        for(int i = 0; i < strs.length; i++) {
            s += strs[i];
        }
        s = s.substring(0, s.length() - 1);
        return s.toCharArray();
    }
}
