public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> list = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String s = String.valueOf(arr);
            if(!map.containsKey(s)){
                List<String> sublist = new ArrayList<>();
                map.put(s, sublist);
            }
            map.get(s).add(strs[i]);
        }
        for(String str : map.keySet()){
            List<String> sublist = map.get(str);
            if(sublist.size() >= 2){
                for(String s : sublist){
                    list.add(s);
                }
            }
        }
        return list;
    }
}
