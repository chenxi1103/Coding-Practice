class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            if(i == 0) {
                list.add(1);
                result.add(list);
                continue;
            }
            for(int j = 0; j <= i; j++) {
                if(j == 0) {
                    list.add(1);
                } else if (j == i) {
                    list.add(1);
                } else {
                    list.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
                }
            }
            result.add(list);
        }
        return result;
    }
}
