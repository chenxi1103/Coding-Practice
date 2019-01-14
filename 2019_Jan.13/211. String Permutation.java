public class Solution {
    /**
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
    public boolean Permutation(String A, String B) {
        // write your code here
        if(A.length() != B.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] splitA = A.toCharArray();
        char[] splitB = B.toCharArray();
        for(int i = 0; i<splitA.length; i++){
            if(map.containsKey(splitA[i])){
                map.put(splitA[i], map.get(splitA[i]) + 1);
            }else{
                map.put(splitA[i], 1);
            }
            if(map.containsKey(splitB[i])){
                map.put(splitB[i], map.get(splitB[i]) - 1);
            }else{
                map.put(splitB[i], -1);
            }
        }
        for(char key : map.keySet()){
            if(map.get(key) != 0){
                return false;
            }
        }
        return true;
    }
}
