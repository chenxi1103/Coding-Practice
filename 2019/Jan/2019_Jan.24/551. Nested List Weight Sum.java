//递归依然写的像💩，多练习啊多练习！！！
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        // Write your code here
        return helper(nestedList, 1);
    }
    public int helper(List<NestedInteger> nestedList, int level){
        if(nestedList == null || nestedList.size() == 0) return 0;
        int sum = 0;
        for(int i = 0; i < nestedList.size(); i++){
            if(nestedList.get(i).isInteger()){
                sum += nestedList.get(i).getInteger() * level;
            }else{
                sum += helper(nestedList.get(i).getList(), level + 1);
            }
        }
        return sum;
    }
}
