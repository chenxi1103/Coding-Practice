public class Solution {
    /**
     * @param n: the nth
     * @return: the nth sequence
     * 听着歌写，写了半个小时，简直有毒，明明是最简单的count and say，可能不要太骚写recursion好一点2333
     */
    public String countAndSay(int n) {
        // write your code here
        String old = "1";
        while(--n > 0){
            char[] curr = old.toCharArray();
            StringBuffer sb = new StringBuffer();
            int count = 1;
            for(int i = 0; i<curr.length-1; i++){
                if(curr[i+1] == curr[i]){
                    count++;
                }else{
                    sb.append(String.valueOf(count)+Character.toString(curr[i]));
                    count = 1;
                }
            }
            sb.append(String.valueOf(count)+Character.toString(curr[curr.length-1]));
            old = sb.toString();
        }
        return old;
    }
}
