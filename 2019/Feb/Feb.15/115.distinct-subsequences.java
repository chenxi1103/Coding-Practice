class Solution {
    public int numDistinct(String s, String t) {
        int[][] matched = new int[s.length() + 1][t.length() + 1];
        //如果t是空字符串，s的每个字符都匹配
        for(int i = 0; i <= s.length(); i++) {
            matched[i][0] = 1;
        }
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= t.length(); j++) {
                //如果当前对应的s和t的字符不等，可以把当前的s跳过去，继续匹配，所以等于matched[i-1][j]
                matched[i][j] = matched[i-1][j];
                //如果相等，就等于之前匹配的结果，加上现在的结果。
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    matched[i][j] += matched[i-1][j-1];
                }
            }
        }
        return matched[s.length()][t.length()];
    }
}
