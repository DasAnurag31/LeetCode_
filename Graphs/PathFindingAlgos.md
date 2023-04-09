## Single Source Shortest Path
### Dijkstra Algo:
* Findind Shortest Path when all Weights are positive
Algo :
* Choose a Source
* Make a Matrix of all the vertices except the Source Vertex
* Fill all columns with +INFINITY 
* Traverse the columns and when you find the shortest add it to the current 
* Categorise the vertex with min in the above step as selected and visited vertex and change the current
* Apart from the visited vertices traverse the cols and find ther min distance from the current and change if lesser
* Repeat till you have traversed all the nodes
### Bellman Ford:
* Finding Shortest Path when Weights are negative 
* The Graph should not have a cycle which will result to a path length of negative 
Algo :
* If no of vertices are N then the no of itterations are N-1 times
* Select a Source and make it's path 0 and all others as infinity
* Calculate the shortest length for each set of vertices in every itterations and change the path of vertices
