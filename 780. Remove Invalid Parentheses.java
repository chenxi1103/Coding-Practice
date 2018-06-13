public class Solution {
    public int removed;
    /**
     * @param s: The input string
     * @return: Return all possible results
     */
    public List<String> removeInvalidParentheses(String s) {
        Map<Integer, List<String>> map = new HashMap();
        List<String> list = new ArrayList();
        StringBuilder sb = new StringBuilder(s);
        removed = 0;
        
        helper(s, sb, list, map, 0);
        for (int i = 0; i <= s.length(); i++) {
            if (map.containsKey(i)) {
                return map.get(i);
            }
        }
        return list;
    }
    
    private void helper(String s,
                        StringBuilder sb,
                        List<String> list,
                        Map<Integer, List<String>> map,
                        int index) {
        
        if (index >= sb.length()) {
            return;
        }
        if (sb.charAt(index) != '(' && sb.charAt(index) != ')') {
            return;
        }
        for (int i = index; i < sb.length(); i++) {
            if (i > index && sb.charAt(i) == sb.charAt(i - 1)){
                continue;
            }
            sb.deleteCharAt(i);
            removed++;
            if (isValid(sb)) {
                list.add(sb.toString());
                map.put(removed, list);
            }
            helper(s, sb, list, map, i);
            sb.insert(i, s.charAt(i + removed - 1));
            removed--;
            list = new ArrayList();
        }
    }
    
    private boolean isValid(StringBuilder str) {
        if (str == null && str.length() == 0) {
            return true;
        }
        
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            } else if (str.charAt(i) == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return (count == 0);
    }
}


