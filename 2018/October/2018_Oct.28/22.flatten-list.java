/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {

    // @param nestedList a list of NestedInteger
    // @return a list of integer
    // 递归的方法如下：
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        if(nestedList == null || nestedList.size() == 0) return result;
        for(int i = 0; i<nestedList.size(); i++){
            if(nestedList.get(i).isInteger()){
                result.add(nestedList.get(i).getInteger());
            }else{
                result.addAll(flatten(nestedList.get(i).getList()));
            }
        }
        return result;
    }
}


public class Solution {

    // @param nestedList a list of NestedInteger
    // @return a list of integer
    // 非递归写法，这道题写的不是很熟练，需要复习！
    // oct-28-11:58
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        if(nestedList == null || nestedList.size() == 0) return result;
        boolean flag = true;
        while(flag){
            flag = false;
            List<NestedInteger> list = new ArrayList<>();
            for(NestedInteger ni : nestedList){
                if(ni.isInteger()){
                    list.add(ni);
                }else{
                    list.addAll(ni.getList());
                    flag = true;
                }
            }
            nestedList = list;
        }
        for(NestedInteger ni : nestedList){
            result.add(ni.getInteger());
        }
        return result;
    }
}
