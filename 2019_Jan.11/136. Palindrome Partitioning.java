public class Solution {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        dfs(s, result, new ArrayList<String>(), 0);
        return result;

    }
    private boolean isPalindrone(String s){
        if(s == null || s.length() <= 1) return true;
        int left = 0, right = s.length() -1;
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
            return;
        }
        for(int i = index; i < s.length(); i++){
            String curr_str = s.substring(index, i+1);
            if(!isPalindrone(curr_str)) continue;
            subset.add(curr_str);
            dfs(s, result, subset, i+1);
            subset.remove(subset.size() - 1);
        }
    }
}
