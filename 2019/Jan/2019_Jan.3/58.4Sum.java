//四指针，很难缠，多联系
public class Solution {
    /**
     * @param numbers: Give an array
     * @param target: An integer
     * @return: Find all unique quadruplets in the array which gives the sum of zero
     */
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        // write your code here
        List<List<Integer>> list = new ArrayList<>();
        if(numbers == null || numbers.length < 4) return list;
        Arrays.sort(numbers);
        for(int i = 0; i<numbers.length -3; i++){
            if(i > 0 && numbers[i] == numbers[i-1]){
                continue;
            }
            for(int j = i+1; j<numbers.length - 2; j++){
                if(j > i+1 && numbers[j] == numbers[j-1]){
                    continue;
                }
                for(int k = j+1, n = numbers.length - 1; k<n; k++){
                    if(k > j+1 && numbers[k] == numbers[k-1]){
                        continue;
                    }
                    while(k<n && numbers[i] + numbers[j] + numbers[k] + numbers[n] > target){
                        n--;
                    }
                    if(k>=n) break;
                    if(numbers[i] + numbers[j] + numbers[k] + numbers[n] == target){
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(numbers[i]);
                        temp.add(numbers[j]);
                        temp.add(numbers[k]);
                        temp.add(numbers[n]);
                        list.add(temp);
                    }
                }
            }
        }
        return list;
    }
}
