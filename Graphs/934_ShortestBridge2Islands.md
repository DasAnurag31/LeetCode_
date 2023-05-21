# Shortest dis bet lsland | Graph
## Algo:
* Find the first index where a land is detected
* SInce we know that only two pieces of islands exist therefore mark the first island from the first index 
* Now we have the first island water and second island seperately marked
* Start Traversing the first island and count distance of BFS from each node until you touch the second island and return that distance else return -1

## Code:
```
class Solution {
    private int dirR[] = { -1, 0, 1, 0 };
    private int dirC[] = { 0, 1, 0, -1 };
    class pair{
        int x;
        int y;
        public pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    private boolean isValid(int x,int y,int[][] grid){
        int size = grid.length;
        if (x < 0 || y < 0 || x >= size || y >= size)
        {
            return false;
        }
        
        if (grid[x][y] == 2 || grid[x][y] == 0){
            return false;    
        }
        return true;
    }
    private int[] findFirstLand(int[][]grid){
        int i = 0 ,j = 0;
        for(i = 0 ; i < grid.length ; i++){
            for(j = 0 ; j < grid.length ; j++){
                if(grid[i][j] == 1){
                    return (new int[]{i,j});
                }
            }
        }
        return (new int[]{i,j});
    }
    private void markIslandA(int[][] grid, int[] firstIndex, int size){
        int row = firstIndex[0];
        int col = firstIndex[1];
        Queue<pair> queue = new LinkedList<>();
        queue.offer(new pair(row,col));
        grid[row][col] = 2; // marking all island blocks of A as 2
        while(!queue.isEmpty()){
            pair cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            for(int i = 0 ; i < 4 ; i++){
                int newX = x + dirR[i];
                int newY = y + dirC[i];
                if(isValid(newX,newY,grid)){
                    queue.offer(new pair(newX,newY));
                    grid[newX][newY] = 2;
                } 
            }
        }
    }
    // public void display(int [][]grid){
    //     for(int i =0 ;i< size; i++){
    //         for(int j =0 ;j<size;j++){
    //             System.out.print(grid[i][j]+" ");
    //         }
    //         System.out.println();
    //     }
    // }
    public int findBridge(int[][] grid){
        Queue<pair> queue = new LinkedList<>();
        int size = grid.length;
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                if(grid[i][j] == 2)
                queue.offer(new pair(i,j));
            }
        }
        int distance = 0;
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0 ; i < len ; i++){
                pair cur = queue.poll();
                int x = cur.x;
                int y = cur.y;
                for(int j = 0 ; j < 4 ; j++){
                    int newX = x + dirR[j];
                    int newY = y + dirC[j];
                    if(newX >=0 && newY >= 0 && newX < size && newY < size && grid[newX][newY]!= 2){
                        if(grid[newX][newY] == 1){
                            return distance;
                        }
                        queue.offer(new pair(newX,newY));
                        grid[newX][newY] = 2;
                    }
                }
            } 
            distance++;
        }
        return -1;
    }
    public int shortestBridge(int[][] grid) {
        int size = grid.length;
        int[] firstIndex = new int[2];
        firstIndex = findFirstLand(grid);
        markIslandA(grid,firstIndex,size);
        // now find the shortest distance between island A and island B
        return findBridge(grid);
    }
}
```

## Approach 2 
* Put Island 1 in hash with pairs of indexes
* Put Island 2 in hash with pairs of indexes
* Calculate the min distance between any two pairs of first and second
* distance between any two pair of index = p1-p2 = x2-x1 + y2+y1 - 1; 
