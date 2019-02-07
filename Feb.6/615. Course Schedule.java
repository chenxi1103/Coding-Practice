public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
        // write your code here
        if(prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) return true;
        List[] neighbors = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            neighbors[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < prerequisites.length; i++) {
            int[] curr = prerequisites[i];
            neighbors[curr[1]].add(curr[0]);
            indegree[curr[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int currCourse = queue.poll();
                count++;
                List list = neighbors[currCourse];
                for(int j = 0; j < list.size(); j++) {
                    int index = (int)list.get(j);
                    indegree[index]--;
                    if(indegree[index] == 0) {
                        queue.offer(index);
                    }
                }

            }
        }
        return count == numCourses;
    }
}
