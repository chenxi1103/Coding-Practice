public class Solution {
    /**
     * @param originalString: a string
     * @return: a compressed string
     * 和data structure的lab一模一样，不解释，注意最后一个的处理
     * nov4th 2:23pm
     */
    public String compress(String originalString) {
        // write your code here
        if(originalString == null || originalString.length() == 0) return originalString;
        int prev = 0;
        int curr = 0;
        int count = 0;
        StringBuffer sb = new StringBuffer();
        while(curr<originalString.length()){
            if(originalString.charAt(curr) == originalString.charAt(prev)){
                curr++;
                count++;
            }else{
                sb.append(Character.toString(originalString.charAt(prev)));
                sb.append(count);
                count = 0;
                prev = curr;
            }
        }
        sb.append(Character.toString(originalString.charAt(prev)));
        if(count != 0) sb.append(count);
        if(sb.toString().length()>=originalString.length()) return originalString;
        return sb.toString();
    }
}
