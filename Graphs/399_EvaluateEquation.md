# Graph | Path A to B | BFS
## Concept:
* Take each dividend and divisor as nodes 
* A/B is A->B & B/A is B->A
* Similarly for A->C = A->B->C that is 

## Code:
```
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] results = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String dividend = query.get(0);
            String divisor = query.get(1);

            if (!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
                results[i] = -1.0;
            } else {
                results[i] = bfs(dividend, divisor, graph);
            }
        }

        return results;
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
// Iterate on the equations list of lists of string and map it with the values array
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String dividend = equation.get(0);
            String divisor = equation.get(1);
            double value = values[i];
// Create a HashMap for a character if it is not already present in the graph
            graph.putIfAbsent(dividend, new HashMap<>());
            graph.putIfAbsent(divisor, new HashMap<>());
// After creating a HashMap for the character, map the divisor and the divident maps accordingly
            graph.get(dividend).put(divisor, value);
            graph.get(divisor).put(dividend, 1.0 / value);
        }
        return graph;
    }
// Finding the Path from dividend to divisor keeping the track of the product
    private double bfs(String start, String end, Map<String, Map<String, Double>> graph) {
        // pair of current character and product
        Queue<Pair<String,Double>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new Pair<>(start, 1.0));

        while (!queue.isEmpty()) {
            Pair<String, Double> pair = queue.poll();
            String node = pair.getKey();
            double value = pair.getValue();

            if (node.equals(end)) {
                return value;
            }

            visited.add(node);

            for (Map.Entry<String, Double> neighbor : graph.get(node).entrySet()) {
                String neighborNode = neighbor.getKey();
                double neighborValue = neighbor.getValue();

                if (!visited.contains(neighborNode)) {
                    queue.offer(new Pair<>(neighborNode, value * neighborValue));
                }
            }
        }

        return -1.0;
    }
}

```
