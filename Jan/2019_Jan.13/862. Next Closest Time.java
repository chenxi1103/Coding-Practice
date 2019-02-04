//DFS写着好长哦…
public class Solution {
    /**
     * @param time: the given time
     * @return: the next closest time
     */
    public String nextClosestTime(String time) {
        // write your code here
        String new_time = time.split(":")[0] + time.split(":")[1];
        char[] nums= new_time.toCharArray();
        char[] no_duplicate = removeDuplicate(nums);
        List<String> result = new ArrayList<>();
        dfs(no_duplicate, result, "");
        int min = Integer.MAX_VALUE, index = 0;
        for(int i = 0; i<result.size(); i++){
            int curr_diff = timeDiff(time, result.get(i));
            if(curr_diff < min){
                min = curr_diff;
                index = i;
            }
        }
        String closest = result.get(index);
        return closest.substring(0,2) + ":" + closest.substring(2,4);

    }
    private void dfs(char[] nums, List<String> result, String subset){
        if(subset.length() == 4){
            result.add(new String(subset));
            return;
        }
        for(int i = 0; i<nums.length; i++){
            subset += nums[i];
            dfs(nums, result, subset);
            subset = subset.substring(0, subset.length() - 1);
        }
    }

    private char[] removeDuplicate(char[] nums){
        int count = 1;
        for(int i = 1; i<nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[count++] = nums[i];
            }
        }
        char[] result = new char[count];
        for(int i = 0; i<count; i++){
            result[i] = nums[i];
        }
        return result;
    }

    private int timeDiff(String time1, String time2){
        int hour1 = Integer.parseInt(time1.split(":")[0]);
        int min1 = Integer.parseInt(time1.split(":")[1]);
        int hour2 = Integer.parseInt(time2.substring(0,2));
        int min2 = Integer.parseInt(time2.substring(2,4));
        if(hour2 > 23 || min2 > 59) return Integer.MAX_VALUE;
        int hourDiff = 0, minDiff = 0;
        if(min1 > min2){
            minDiff = min2 + 60 - min1;
            hour2--;
        }else{
            minDiff = min2 - min1;
        }
        if(hour1 > hour2){
            hourDiff = hour2 + 24 - hour1;
        }else{
            hourDiff = hour2 - hour1;
        }
        if(hourDiff == 0 && minDiff == 0) return Integer.MAX_VALUE;
        return hourDiff * 60 + minDiff;
    }
}

/////////////////////////////这个更长，但是快一点/////////////////////
public class Solution {
    /**
     * @param time: the given time
     * @return: the next closest time
     */
    public String nextClosestTime(String time) {
        // write your code here
        int hour = Integer.parseInt(time.substring(0,2));
        int min = Integer.parseInt(time.substring(3,5));
        String new_time = time.substring(0,2) + time.substring(3,5);
        char[] nums = new_time.toCharArray();
        nums = removeDuplicate(nums);
        List<Integer> hours = new ArrayList<>();
        List<Integer> mins = new ArrayList<>();
        dfs(nums, hours, mins, "");
        Collections.sort(hours);
        Collections.sort(mins);
        int close_hour = hour;
        int close_min = min;
        if(min != mins.get(mins.size() - 1)){
            for(int i = 1; i<mins.size(); i++){
                if(mins.get(i) > min){
                    close_min = mins.get(i);
                    break;
                }
            }
        }else{
            if(hour != hours.get(hours.size() - 1)){
                for(int i = 1; i<hours.size(); i++){
                    if(hours.get(i) > hour){
                        close_hour = hours.get(i);
                        close_min = mins.get(0);
                        break;
                    }
                }
            }else{
                close_hour = hours.get(0);
                close_min = mins.get(0);
            }
        }
        String new_hour = String.valueOf(close_hour);
        String new_min = String.valueOf(close_min);
        if(new_hour.length() == 1){
            new_hour = "0" + new_hour;
        }
        if(new_min.length() == 1){
            new_min = "0" + new_min;
        }
        return new_hour + ":" + new_min;
    }

    private char[] removeDuplicate(char[] nums){
        int count = 1;
        for(int i = 1; i<nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[count++] = nums[i];
            }
        }
        char[] result = new char[count];
        for(int i = 0; i<count; i++){
            result[i] = nums[i];
        }
        return result;
    }

    private void dfs(char[] nums, List<Integer> hours, List<Integer> mins, String subset){
        if(subset.length() == 2){
            int num = Integer.parseInt(subset);
            if(num < 24){
                mins.add(num);
                hours.add(num);
            }else if(num < 60){
                mins.add(num);
            }
            return;
        }
        for(int i = 0; i< nums.length; i++){
            subset += nums[i];
            dfs(nums,hours,mins,subset);
            subset = subset.substring(0, subset.length() - 1);
        }
    }
}
