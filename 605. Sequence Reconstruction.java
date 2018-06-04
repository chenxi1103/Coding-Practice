public class Solution {
    /**
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        HashMap<Integer,Set<Integer>> map = new HashMap<Integer,Set<Integer>>();
        Map<Integer,Integer> indegree = new HashMap<Integer,Integer>();
        
        for(int nums:org){
            map.put(nums,new HashSet<Integer>());//需要nums做先修的数存在set里
            indegree.put(nums,0);//初始化所有nums入度为0
        }
        
        int n = org.length;
        int count = 0;
        //统计入度，统计连接情况
        for(int[] seq:seqs){
            count+=seq.length; //为了最后算org的元素数是不是小于seqs的元素数
            if(seq.length>=1&&(seq[0]<=0||seq[0]>n)){
                return false;//保证seq里的数符合1《seq[i]《n(粗略判断)
            }
            for(int i = 1; i<seq.length;i++){
                if(seq[i]<=0||seq[i]>n) return false; //仔细判断每个数都在1~n中
                //现在map里装的都是org里的数，现在判断这些数是否包含seq[i-1]这个数
                //如果包含，把seq[i]加入它对应的value里因为seq[i-1]是seq[i]的先修
                if(map.get(seq[i-1]).add(seq[i])){
                    //seq[i]的入度+1因为又找到一个先修
                    indegree.put(seq[i],indegree.get(seq[i])+1);
                }
            }
        }
        //for循环结束后，看org是不是小于seqs的元素数
        if(count < n) return false;
        //开始BFS的部分
        //首先无脑new一个queue
        Queue<Integer> queue = new LinkedList<Integer>();
        //把所有入度为0的都打进queue里(其实只有一个)
        for(int key : indegree.keySet()){
            if(indegree.get(key) == 0){
                queue.offer(key);
            }
        }
        //因为对于org和seq来说，只有一个总的第一节点，就是org的第一个元素
        //其他元素都有入度，都有元素相连，所以：
        int counter = 0;
        while(queue.size() == 1){
            int currNum = queue.poll();
            //要判断一下每个数是不是都能和org对的上
            if(currNum != org[counter]) return false;
            //遍历当前数是哪些数的先修，也就是遍历map
            for(int nextNum : map.get(currNum)){
                //因为先修已经修过了，相连的数入度都减1
                indegree.put(nextNum,indegree.get(nextNum)-1);
                if(indegree.get(nextNum) == 0){
                    queue.offer(nextNum);
                }
            }
            counter++;
        }
        //之前对应性也判断过了，如果长度也一致，说明true
        return counter == org.length;
    }
}
