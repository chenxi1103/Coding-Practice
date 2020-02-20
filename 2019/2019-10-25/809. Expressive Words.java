//呜呜呜这道题的corner case太多了，如果按照word一个一个字符检查，是检查不到最后一个字符的
//要检查s和word的长度，要检查s的index是不是越界了，要检查最后一个字符如果重复了是不是重复超过3个，
//corner case太多，交了6遍才过，考虑不到这么多真的很难受。
class Solution {
    public int expressiveWords(String S, String[] words) {
        int result = 0;
        for(int i = 0; i < words.length; i++) {
            if (isExpressive(S, words[i])) result++;
        }
        return result;
    }
    private boolean isExpressive(String S, String word) {
        if (word.length() > S.length()) return false;
        char[] charS = S.toCharArray();
        char[] charW = word.toCharArray();
        int ctn = 0;
        for (int i = 0; i < charW.length; i++) {
            if (ctn >= charS.length) return false;
            if (charW[i] == charS[ctn]) {
                ctn++;
            } else {
                if (i == 0) return false;
                while(charS[ctn] == charW[i-1]) {
                    ctn++;
                }
                if (charW[i] != charS[ctn]) return false;
                if (countSimilarChar(S, ctn - 1) < 3) return false;
                ctn++;
            }
        }
        if (ctn == charS.length) return true;

        while (ctn <= charS.length - 1) {
            if (charS[ctn] != charW[charW.length - 1]) return false;
            ctn++;
        }
        if (countSimilarChar(S, S.length() - 1) < 3) return false;
        return true;
    }

    private int countSimilarChar(String S, int index) {
        int counter = 0;
        int i = index;
        while (i >= 0 && S.charAt(i) == S.charAt(index)) {
            i--;
            counter++;
        }
        return counter;
    }
}
