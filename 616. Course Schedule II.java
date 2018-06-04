public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int counter = 0;
        List[] edges = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        for(int i = 0; i<numCourses; i++){
            edges[i] = new ArrayList();
        }
        for(int i = 0; i<prerequisites.length;i++){
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
            int courseTaken = (int) queue.poll();
            result.add(courseTaken);
            counter++;
            int len = edges[courseTaken].size();
            for(int i = 0; i<len; i++){
                int pointer = (int) edges[courseTaken].get(i);
                degree[pointer]--;
                if(degree[pointer] == 0){
                    queue.offer(pointer);
                }
            }
        }
        if(counter == numCourses){
            int[] realResult = new int[result.size()];
            for(int i = 0; i<result.size();i++){
                realResult[i] = result.get(i);
            }
            return realResult;
        }
        else return new int[0];
    }
}
