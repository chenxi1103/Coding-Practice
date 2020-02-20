class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cows = 0;
        char[] charArray1 = secret.toCharArray();
        char[] charArray2 = guess.toCharArray();
        int[] mark = new int[10];
        for (int i = 0; i <charArray1.length; i++) {
            if (charArray1[i] != charArray2[i]) {
                mark[Integer.parseInt(charArray1[i] + "")]++;
            }
        }

        for (int i = 0; i < charArray1.length; i++) {
            if (charArray1[i] == charArray2[i]) {
                bull++;
            }
            else {
                if (mark[Integer.parseInt(charArray2[i] + "")] > 0) {
                    cows++;
                    mark[Integer.parseInt(charArray2[i] + "")]--;
                }
            }
        }
        return bull+"A"+cows+"B";
    }
}
