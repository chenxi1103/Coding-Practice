class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if(rowIndex == 0) return list;
        for(int i = 1; i <= rowIndex; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j = 1; j < i; j++) {
                temp.add(list.get(j-1) + list.get(j));
            }
            temp.add(1);
            list = temp;
        }
        return list;
    }
}
