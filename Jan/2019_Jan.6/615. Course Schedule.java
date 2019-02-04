//更难一点的拓扑排序，要用两个list或者array，一个存入度，一个存先修课关系！那种有向图数据结构不一样！要自己去存指向关系！
public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
        if(prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) return true;
        List[] prerequisite = new ArrayList[numCourses];
        for(int i = 0; i<numCourses; i++){
            prerequisite[i] = new ArrayList<Integer>();
        }
        int[] indegree = new int[numCourses];
        for(int i = 0; i<prerequisites.length; i++){
            prerequisite[prerequisites[i][1]].add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i<numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            int course = queue.poll();
            int size = prerequisite[course].size();
            List<Integer> courses = prerequisite[course];
            for(int i = 0; i<size; i++){
                indegree[courses.get(i)] = indegree[courses.get(i)] - 1;
                if(indegree[courses.get(i)] == 0){
                    queue.offer(courses.get(i));
                }
            }
            count++;
        }
        return count == numCourses;
    }
}
