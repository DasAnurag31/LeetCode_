# Time Info Emp | Create TREE
## Algo:
* Create a Tree
* NODE = ID, TIME SUM
* Return the max TIME SUM of all nodes
## Code:
```
class Solution {
    int maxTime = Integer.MIN_VALUE;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

    // Step 1: Create a Adjacency Graph (Every Tree is a directed Acyclic Graph )
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }

    // Step 2: Fill Out the graph Accordingly
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                adjList.get(manager[i]).add(i);
            } 
        }

    // Step 3: Traditional BFS Using QUEUE 
        int headTime = informTime[headID];

        // STRUCTURE OF NODE : PAIR (KEY-> VALUE) : (ID -> TimeOfPropagation)
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(headID, headTime));

        while (!q.isEmpty()) {
            Pair<Integer, Integer> current = q.poll();

            int id = current.getKey(); // First Value in Pair
            int time = current.getValue(); // Second Value in Pair

            maxTime = Math.max(maxTime, time);

            // Traverse all the Children of the Current 
            for (int a : adjList.get(id)) {
                q.add(new Pair<>(a, time + informTime[a]));
            }
        }

        // Return the MAX value of time out of all the nodes in the tree 
        return maxTime;
    }
}
```
