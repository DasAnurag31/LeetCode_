# Detonate Max | Graph 
## Algo :
* Create a ADJ List and find the largest path (max visited size)
## Code :
```
class Solution {
    public int bfs(Map<Integer, List<Integer>> graph, int i){
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(i);
        visited.add(i);
        while (!queue.isEmpty()){
            int cur = queue.poll();
            for(int neib : graph.getOrDefault(cur, new ArrayList<>())){
            if (!visited.contains(neib)) {
                    visited.add(neib);
                    queue.offer(neib);
                }
            }
        }
        return visited.size();
    }
    public int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int n = bombs.length;
        // Create an Adjacency List 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int xi = bombs[i][0], yi = bombs[i][1], ri = bombs[i][2];
                int xj = bombs[j][0], yj = bombs[j][1];
                long x = xi - xj;
                long y = yi - yj;
                long d = (x*x + y*y);
                if(d <= (long)ri*ri){
                    graph.computeIfAbsent(i,key -> new ArrayList<Integer>()).add(j);
                }
            }
        }
        // Find the Longest Path by BFS 
        int max = 0;
        for(int i = 0 ; i < n; i++){
            max = Math.max(max,bfs(graph,i));
        }
        return max;
    }
}
```
