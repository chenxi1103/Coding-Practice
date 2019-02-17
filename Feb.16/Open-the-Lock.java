class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        for(String deadend : deadends) {
            dead.add(deadend);
        }
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        set.add("0000");
        if(dead.contains("0000")) return -1;
        if(dead.contains(target)) return -1;
        int steps = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String currStr = queue.poll();
                if (currStr.equals(target)) {
                    return steps;
                }
                List<String> list = moveWheels(currStr);
                for(String str : list) {
                    if(!set.contains(str) && !dead.contains(str)) {
                        queue.offer(str);
                        set.add(str);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    private List<String> moveWheels(String str) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            String s1 = str.substring(0, i) + (str.charAt(i) == '9' ? 0 : (str.charAt(i) - '0' + 1)) + str.substring(i+1, 4);
            String s2 = str.substring(0, i) + (str.charAt(i) == '0' ? 9 : (str.charAt(i) - '0' - 1)) + str.substring(i+1, 4);
            list.add(s1);
            list.add(s2);
        }
        return list;
    }
}
