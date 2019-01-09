//经典题，记住！
public class Solution {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        if(s == null){
            return result;
        }
        dfs(s, result, new ArrayList<String>(), 0);
        return result;
    }

    private boolean isPalindrome(String s){
        if(s == null || s.length() == 0){
            return false;
        }
        int left = 0, right = s.length() - 1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    private void dfs(String s, List<List<String>> result, ArrayList<String> subset, int index){
        if(index == s.length()){
            result.add(new ArrayList<String>(subset));
        }
        for(int i = index; i<s.length(); i++){
            String str = s.substring(index, i+1);
            if(!isPalindrome(str)){
                continue;
            }
            subset.add(str);
            dfs(s, result, subset, i+1);
            subset.remove(subset.size() - 1);
        }
    }
}
