public class Solution {
    /**
     * @param s1: the first string
     * @param s2: the socond string
     * @return: true if s2 is a rotation of s1 or false
     * 一个比较笨的方法，注意不能用找单个头节点的方式，因为可能出现abba/aabb的情况，这个时候
     * 头节点是第二个a，不是第一个a，如果把第一个a当头节点，就会返回false
     * nov4th 2:41pm
     */
    public boolean isRotation(String s1, String s2) {
        // write your code here
        if(s1.length() != s2.length()) return false;
        for(int i = 0; i<s2.length(); i++){
            StringBuffer sb = new StringBuffer();
            sb.append(s2.substring(i+1,s2.length()));
            sb.append(s2.substring(0,i+1));
            if(sb.toString().equals(s1)) return true;
        }
        return false;
    }
}
