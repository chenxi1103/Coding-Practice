public class Solution {
    /**
     * @param str: A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        List<String> list = new ArrayList();
        if (str.length() == 0) {
            list.add(str);
            return list;
        }
        char[] char_array = str.toCharArray();
        Arrays.sort(char_array);
        helper(char_array, list, new StringBuilder(), new boolean[str.length()]);
        return list;
    }
    
    private void helper(char[] char_array,
                        List<String> list,
                        StringBuilder sb,
                        boolean[] used) {
        
        if (sb.length() == char_array.length) {
            list.add(new String(sb.toString()));
            return;
        }
        
        for (int i = 0; i < char_array.length; i++) {
            if (i != 0 && (char_array[i] == char_array[i-1]) && !used[i-1]) {
                continue;
            }
            if (used[i]) {
                continue;
            }
            sb.append(char_array[i]);
            used[i] = true;
            helper(char_array, list, sb, used);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
        return;
    }
}
