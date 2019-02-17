class Solution {
    public int minDistance(String word1, String word2) {
        if(word2 == null) return 0;
        if(word1 == null) return word2.length();
        int[][] matched = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 0; i <= word1.length(); i++) {
            matched[i][0] = i;
        }
        for(int j = 0; j <= word2.length(); j++) {
            matched[0][j] = j;
        }
        for(int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    matched[i][j] = matched[i-1][j-1];
                } else {
                    // replace: matched[i-1][j-1]
                    // delete: matched[i-1][j]
                    // insert: matched[i][j-1]
                    matched[i][j] = Math.min(Math.min(matched[i-1][j-1], matched[i-1][j]), matched[i][j-1]) + 1;
                }
            }
        }
        return matched[word1.length()][word2.length()];
    }
}
