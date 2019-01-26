//亚麻1
public class Solution {
    /**
     * @param s: the string s
     * @param k: the maximum length of substring
     * @return: return the least number of substring
     */
    public int getAns(String s, int k) {
        // Write your code here
        int result = 0;
        char[] charlist = s.toCharArray();
        int count = 1;
        for(int i = 1; i < charlist.length; i++){
            if(charlist[i-1] == charlist[i] && count < k){
                count++;
            }else{
                result++;
                count = 1;
            }
        }
        return result+1;
    }
}
