class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++) graph[i] = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int[] a: prerequisites){
                int u = a[0];
                int v = a[1];
                indegree[v]++;
                graph[u].add(v);
            }
        }
        ArrayDeque<Integer> que = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++) if(indegree[i] == 0) que.addLast(i);
        int count = 0;
        while(que.size()!=0){
            int vrtx = que.removeFirst();
            count++;
            for(int e : graph[vrtx]){
                if(--indegree[e]==0) que.addLast(e);
            }
        }
        return count==numCourses;
    }
}
