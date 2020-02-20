//和course schedule是一个套路，但是注意要检查是否有闭环的情况，闭环的存在即count！=numCourses，不检查会出错！记住！
public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here
        int[] result = new int[numCourses];
        if(prerequisites == null || prerequisites.length == 0){
            for(int i = 0; i<numCourses; i++){
                result[i] = i;
            }
            return result;
        }

        List[] pre_courses = new ArrayList[numCourses];
        int[] indegrees = new int[numCourses];
        for(int i = 0; i<numCourses; i++){
            pre_courses[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i<prerequisites.length; i++){
            pre_courses[prerequisites[i][1]].add(prerequisites[i][0]);
            indegrees[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i<numCourses;i++){
            if(indegrees[i] == 0){
                queue.offer(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            int course = queue.poll();
            result[count++] = course;
            if(count > numCourses) return new int[0];
            List<Integer> pre_course = pre_courses[course];
            for(int i = 0; i<pre_course.size(); i++){
                indegrees[pre_course.get(i)] = indegrees[pre_course.get(i)] - 1;
                if(indegrees[pre_course.get(i)] == 0) queue.offer(pre_course.get(i));
            }
        }
        //就是这里检查闭环情况！！！
        
        if(count != numCourses) return new int[0];
        return result;
    }
}
