public class Solution {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    public List<String> letterCombinations(String digits) {
        Map<Character, char[]> map = new HashMap();
        map.put('2', new char[] {'a', 'b', 'c'});
        map.put('3', new char[] {'d', 'e', 'f'});
        map.put('4', new char[] {'g', 'h', 'i'});
        map.put('5', new char[] {'j', 'k', 'l'});
        map.put('6', new char[] {'m', 'n', 'o'});
        map.put('7', new char[] {'p', 'q', 'r', 's'});
        map.put('8', new char[] {'t', 'u', 'v'});
        map.put('9', new char[] {'w', 'x', 'y', 'z'});
        
        List<String> list = new ArrayList();
        if (digits.length() == 0 || digits == null) {
            return list;
        }
        helper(digits, map, new StringBuilder(), list, 0);
        return list;
    }
    
    private void helper(String digits,
                        Map<Character, char[]> map,
                        StringBuilder str,
                        List<String> list,
                        int digits_index) {
        
        if (digits_index == digits.length()) {
            list.add(new String(str.toString()));
            return;
        }
        
        char digit = digits.charAt(digits_index);
        for (char letter: map.get(digit)) {
            str.append(letter);
            helper(digits, map, str, list, digits_index + 1);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
