//这道题可以用robinkarp，回去复习一下这个算法
class Solution {
    public int repeatedStringMatch(String A, String B) {
        if (A == null || B == null || A.length() == 0 || B.length() == 0) return -1;
        int counter = 1;
        StringBuilder sb = new StringBuilder(A);
        while(sb.length() < B.length()) {
            sb.append(A);
            counter++;
        }
        if(sb.indexOf(B) >= 0) return counter;
        if(sb.append(A).indexOf(B) >= 0) return counter + 1;
        return -1;
    }
}
