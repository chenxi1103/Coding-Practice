/////////////////自己的解法///////////////////
class Solution {
    public int shortestWay(String source, String target) {
        char[] charArray = source.toCharArray();
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            if (!map.containsKey(charArray[i])) {
                map.put(charArray[i], new ArrayList<>());
            }
            map.get(charArray[i]).add(i);
        }
        int counter = 1;
        char[] charArray2 = target.toCharArray();
        if (!map.containsKey(charArray2[0])) return -1;
        int lastIndex = map.get(charArray2[0]).get(0);
        for (int i = 1; i < charArray2.length; i++) {
            if (!map.containsKey(charArray2[i])) return -1;
            List<Integer> currIndex = map.get(charArray2[i]);
            int temp = lastIndex;
            for (int index : currIndex) {
                if (index > lastIndex) {
                    lastIndex = index;
                    break;
                }
            }
            if (temp == lastIndex) {
                counter++;
                lastIndex = currIndex.get(0);
            }
        }
        return counter;
    }
}

///////////用双指针显然更明智一些///////////////
class Solution {
    public int shortestWay(String source, String target) {
        int slen = source.length();
        int tlen = target.length();
        int i = 0;
        int j = 0;
        int counter = 1;
        while (i < tlen) {
            int tmp = j;
            while (j < slen && source.charAt(j) != target.charAt(i)) {
                j++;
            }
            if (j == slen) {
                j = 0;
                counter++;
                while (j < tmp && source.charAt(j) != target.charAt(i)) {
                    j++;
                }
                if (j == tmp) return -1;
            }
            i++;
            j++;
        }
        return counter;
    }
}
