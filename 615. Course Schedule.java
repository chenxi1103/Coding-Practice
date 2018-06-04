public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] edges = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        int count = 0;
        for(int i = 0; i<numCourses; i++){
            edges[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i<prerequisites.length; i++){
            degree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        Queue queue = new LinkedList();
        for(int i = 0; i<degree.length;i++){
            if(degree[i] == 0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int courseTaken = (int)queue.poll();
            count++;
            int len = edges[courseTaken].size();
            for(int i = 0; i<len;i++){
                int pointer = (int) edges[courseTaken].get(i);
                degree[pointer]--;
                if(degree[pointer] == 0){
                    queue.offer(pointer);
                }
            }
        }
        return count == numCourses;
    }
}
