//第一个反应可能是用arraylist，不要用，用hashmap比arraylist快很多ß
public class TwoSum {
    /**
     * @param number: An integer
     * @return: nothing
     */
    HashMap<Integer, Integer> map = new HashMap<>();
    public void add(int number) {
        // write your code here
        if(!map.containsKey(number)){
            map.put(number, 1);
        }else{
            map.put(number, map.get(number) + 1);
        }
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here
        for(int key : map.keySet()){
            int diff = value - key;
            if(map.containsKey(diff)){
                if(diff != key || map.get(key) > 1) return true;
            }
        }
        return false;
    }
}
