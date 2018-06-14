public class Solution {
    public int removed;

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList();      //存放结果
        List<String> list = new ArrayList();        //作为传入参数
        StringBuilder sb = new StringBuilder(s);
        removed = 0;
        
        if (s.length() == 0 || s == null) {
            result.add(s);
            return result;
        }
        
        helper(s, sb, list, 0);
        int maxlength = -1;                                     //helper过后所有有效组合都存在list里
        for (String entry: list) {                              //找最大长度（经过最少删除）
            maxlength = Math.max(maxlength, entry.length());
        }
        for (String entry: list) {                              //往result中添加最大长度的组合
            if (entry.length() == maxlength) {
                result.add(entry);
            }
        }
        return result;
    }
    
    private void helper(String s,
                        StringBuilder sb,
                        List<String> list,
                        int index) {
        if (index >= sb.length()) {
            return;
        }
        for (int i = index; i < sb.length(); i++) {
            if (i > index && sb.charAt(i) == sb.charAt(i - 1)){ //去重
                continue;
            }
            sb.deleteCharAt(i);
            removed++;
            if (isValid(sb)) {
                list.add(sb.toString());
            }
            helper(s, sb, list, i);                             //此处依旧传i，因为删除后，后一个char跑到了i位置上
            sb.insert(i, s.charAt(i + removed - 1));            //回溯
            removed--;                                          //回溯
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


