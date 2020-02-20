//这里学到了一个java产生随机数的类，叫Random,可以在题中随意使用！
public class RandomizedSet {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    Random random;
    public RandomizedSet() {
        // do intialization if necessary
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        // write your code here
        if(map.containsKey(val)){
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        // write your code here
        if(!map.containsKey(val)) return false;
        int index = map.remove(val);
        int lastVal = list.remove(list.size() - 1);
        if(val != lastVal){
            list.set(index, lastVal);
            map.put(lastVal,index);
        }
        return true;
    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        // write your code here
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
