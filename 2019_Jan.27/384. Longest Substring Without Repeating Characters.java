public class Solution {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if(s == null) return 0;
        if(s.length() <= 1) return s.length();
        int maxSize = 0;
        HashSet<Character> set = new HashSet<>();
        Queue<Character> queue = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            if(set.contains(s.charAt(i))) {
                if(queue.size() > maxSize) maxSize = queue.size();
                while(queue.peek() != s.charAt(i)) {
                    char curr = queue.poll();
                    set.remove(curr);
                }
                queue.poll();
                queue.offer(s.charAt(i));
            } else {
                set.add(s.charAt(i));
                queue.offer(s.charAt(i));
            }
        }
        return Math.max(maxSize, queue.size());
    }
}
