public class Solution {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    public List<String> letterCombinations(String digits) {
        // write your code here
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        map.put('0', new char[]{});
        map.put('1', new char[]{});
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) return result;
        char[] digit = digits.toCharArray();
        dfs(map, result, digit, new StringBuilder());
        return result;
    }
    private void dfs(HashMap<Character, char[]> map, List<String>result, char[] digit, StringBuilder sb){
        if(sb.length() == digit.length){
            result.add(sb.toString());
            return;
        }
        for(char c : map.get(digit[sb.length()])){
            sb.append(c);
            dfs(map,result,digit,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
