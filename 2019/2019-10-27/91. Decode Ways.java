class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() ==0 || s.charAt(0) == '0') return 0;
        int[] ways = new int[s.length()+1];
        ways[1] = 1;
        if (s.length() >= 2 && Integer.parseInt(s.substring(0, 2)) <= 26) {
            if (s.charAt(1) == '0') {
                ways[2] = 1;
            } else {
                ways[2] = 2;
            }
        } else if (s.length() >= 2 && Integer.parseInt(s.substring(0, 2)) > 26) {
            if (s.charAt(1) == '0') {
                return 0;
            } else {
                ways[2] = 1;
            }
        }

        for (int i = 3; i <= s.length(); i++) {
            if (s.charAt(i-2) == '0') {
                if (s.charAt(i-1) == '0') return 0;
                else ways[i] = ways[i-2];
            } else {
                if (Integer.parseInt(s.substring(i-2, i)) <= 26) {

                if (s.charAt(i - 1) == '0') {
                    ways[i] = ways[i-2];
                } else {
                    ways[i] = ways[i-1] + ways[i-2];
                }
            } else {
                if (s.charAt(i - 1) == '0') {
                    return 0;
                } else {
                    ways[i] = ways[i-1];
                }
            }
        }
        }
        return ways[s.length()];
    }
}
