//复习一下dijkstra算法，network课学过，最短路径
//先initial到所有点的距离都是infinite，然后起点是0
//从起点开始，根据起点到直接相邻neighbor的距离，来更新这个点到起点的距离。记录已经走过的点。
//不需要像bfs一样用queue来存某一层的数据，因为走到每个点的时候，这个点相邻的所有neighbor都会重新更新一遍最短距离，所以不存在“层”这个概念
//直到所有点都visit过了，取距离最长的那个点，就是最大cost（当然，如果这个点的cost依旧是infinite的话，说明没有遍历到它，这个点是isolated的，整个图不能被完全传播
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Integer> dist = new HashMap<>();
        Map<Integer, List<int[]>> graph = new HashMap<>();
        boolean[] visited = new boolean[N];

        for (int i = 0; i < times.length; i++) {
            if (!graph.containsKey(times[i][0])) {
                graph.put(times[i][0], new ArrayList<>());
            }
            graph.get(times[i][0]).add(new int[]{times[i][1], times[i][2]});
        }

        for (int i = 1; i <= N; i++) {
            dist.put(i, Integer.MAX_VALUE);
        }
        dist.put(K, 0);

        while(true) {
            int currNode = -1;
            int currDist = Integer.MAX_VALUE;
            for (int i = 1; i <= N; i++) {
                if (!visited[i-1] && currDist > dist.get(i)) {
                    currDist = dist.get(i);
                    currNode = i;
                }
            }

            if (currNode == -1) break;
            visited[currNode - 1] = true;
            if (graph.containsKey(currNode)) {
                List<int[]> list = graph.get(currNode);
                for (int[] data : list) {
                    dist.put(data[0], Math.min(dist.get(data[0]), dist.get(currNode) + data[1]));
                }
            }
        }

        int result = 0;
        for (int nodedist : dist.values()) {
            if (nodedist == Integer.MAX_VALUE) return -1;
            result = Math.max(result, nodedist);
        }
        return result;
    }
}
