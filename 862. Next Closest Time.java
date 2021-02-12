public class Solution {
    /**
     * @param time: the given time
     * @return: the next closest time
     */
    public String nextClosestTime(String time) {
        int[] nums = new int[4];
        nums[0] = time.charAt(0) - '0';
        nums[1] = time.charAt(1) - '0';
        nums[2] = time.charAt(3) - '0';
        nums[3] = time.charAt(4) - '0';
        
        Arrays.sort(nums);
        
        List<String> list = new ArrayList();
        StringBuilder set = new StringBuilder();
        dfsHelper(nums, list, set);
        
        int index = 0;                                      //找到排列中time的位置，return下一个
        for (int i = 0; i < list.size(); i++) {             //即为所求
            if (time.equals(list.get(i))) {
                index = (i + 1 < list.size())? i + 1 : 0;
                break;
            }
        }
        return list.get(index);
    }
    
    private void dfsHelper(int[] nums,
                            List<String> list,
                            StringBuilder set) {
        
        if (set.length() == 4) {
            if (isValid(set)) {
                set.insert(2,':');
                list.add(new String(set.toString()));     //这里当时搞了好久，主要是后面判断valid时有差异
                set.deleteCharAt(2);                      //此处代码对应验证不带冒号的四位时间是否有效
            }
            return;
        }
                                                          //也可另起一个if (set.length() == 2) set.append(':');
                                                          //这样做的话，前面不需要在set中insert和delete，但是判断valid时要做出修改
        for (int i = 0; i < 4; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            set.append(nums[i]);
            dfsHelper(nums, list, set);
            set.deleteCharAt(set.length() - 1);           //DFS回溯
        }
        return;
    }
    
    private boolean isValid(StringBuilder set) {
        if (set.charAt(0) > '2' || set.charAt(2) > '6') {
            return false;
        }
        if (set.charAt(0) == '2' && set.charAt(1) > '4') {
            return false;
        }
        return true;
    }
}
