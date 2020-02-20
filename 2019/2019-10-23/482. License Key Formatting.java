class Solution {
    public String licenseKeyFormatting(String S, int K) {
        String str = S.replace("-", "");
        if (str.length() < K) return str;
        StringBuilder sb = new StringBuilder();
        int counter = str.length() % K;
        if (counter > 0) {
            sb.append(str.substring(0, counter).toUpperCase() + "-");
        }
        while (counter + K <= str.length()) {
            sb.append(str.substring(counter, counter + K).toUpperCase() + "-");
            counter += K;
        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}
