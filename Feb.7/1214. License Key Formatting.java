public class Solution {
    /**
     * @param S: a string
     * @param K: a integer
     * @return: return a string
     */
    public String licenseKeyFormatting(String S, int K) {
        // write your code here
        S = S.replaceAll("[-]", "");
        S = S.toUpperCase();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(S);
        int dush = S.length() - K;
        while(dush > 0) {
            sb.insert(dush,'-');
            dush = dush - K;
        }
        return sb.toString();
    }
}
