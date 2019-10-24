class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        char[] charArray1 = s.toCharArray();
        char[] charArray2 = t.toCharArray();
        for (int i = 0 ; i < charArray1.length; i++) {
            if (map1.containsKey(charArray1[i])) {
                if (map1.get(charArray1[i]) != charArray2[i]) {
                    return false;
                }
            } else {
                if (map2.containsKey(charArray2[i])) {
                    if (map2.get(charArray2[i]) != charArray1[i]) return false;
                }
                map1.put(charArray1[i], charArray2[i]);
                map2.put(charArray2[i], charArray1[i]);
            }
        }
        return true;
    }
}
