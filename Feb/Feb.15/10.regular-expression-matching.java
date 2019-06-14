//DP 修炼第一题
class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        boolean[][] matched = new boolean[ss.length + 1][pp.length + 1];
        matched[0][0] = true;
        for (int i = 1; i < matched[0].length; i++) {
            if(pp[i-1] == '*') {
                matched[0][i] = matched[0][i-2];
            }
        }

        for(int i = 1; i < matched.length; ++i) {
            for (int j = 1; j < matched[0].length; ++j) {
                if(ss[i-1] == pp[j-1] || pp[j-1] == '.') {
                    matched[i][j] = matched[i-1][j-1];
                } else if(pp[j-1] == '*') {
                    matched[i][j] = matched[i][j-2];
                    if (pp[j-2] == ss[i-1] || pp[j-2] == '.') {
                        matched[i][j] = matched[i][j-2] || matched[i-1][j];
                    }
                } else {
                    matched[i][j] = false;
                }
            }
        }
        return matched[ss.length][pp.length];
    }
}
