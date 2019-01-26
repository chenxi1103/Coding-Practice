public class Solution {
    /**
     * @param words: an array of string
     * @param k: An integer
     * @return: an array of string
     */
    class word implements Comparable<word>{
        private int freq;
        private String content;
        public word(int freq, String content) {
            this.freq = freq;
            this.content = content;
        }
        //题目的要求有很多边界条件要考虑
        @Override
        public int compareTo(word o) {
            //第一先比较freq的大小
            int diff = this.freq - o.freq;
            //当freq一样的时候
            if(diff == 0) {
                int size = Math.min(o.content.length(), this.content.length());
                int count = 0;
                //比较两个单词的alphabet的顺序
                while(count < size && diff == 0) {
                    diff = o.content.charAt(count) - this.content.charAt(count);
                    count++;
                }
            }
            //如果diff还等于0，说明这个单词和另一个单词的重合部分完全一样，那么比价他们的长度
            //长度更长的肯定要排在后面
            if(diff == 0) {
                diff = o.content.length() - this.content.length();
            }
            return diff;
        }
    }
    public String[] topKFrequentWords(String[] words, int k) {
        // write your code here
        HashMap<String, word> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            if(map.containsKey(words[i])){
                map.get(words[i]).freq++;
            }else {
                word currWord = new word(1, words[i]);
                map.put(words[i], currWord);
            }
        }
        //用堆来排序，使得时间复杂度达到o(Logn)
        PriorityQueue<word> pq = new PriorityQueue<>();
        for(String key : map.keySet()) {
            pq.offer(map.get(key));
            while (pq.size() > k) {
                pq.poll();
            }
        }
        String[] result = new String[k];
        for(int i = k-1; i >=0; i--) {
            result[i] = pq.poll().content;
        }
        return result;
    }
}
