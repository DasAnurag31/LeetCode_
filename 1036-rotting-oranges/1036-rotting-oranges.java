class Solution {
    class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private boolean isValid(int x, int y, int n, int m){
        if(x >= 0 && y >= 0 && x < n && y < m){
            return true;
        }
        return false;
    }
    private int[] dirX = {1,-1,0,0};
    private int[] dirY = {0,0,1,-1};

    public int orangesRotting(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        Queue<Pair> queue = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    queue.offer(new Pair(i,j));
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if(fresh == 0){
            return 0;
        }

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0;i<size;i++){
                Pair cur = queue.poll();
                int curX = cur.x;
                int curY = cur.y;
                for(int j=0;j<4;j++){
                    int newX = curX + dirX[j];
                    int newY = curY + dirY[j];

                    if(isValid(newX, newY, n, m) && grid[newX][newY] == 1){
                        grid[newX][newY] = 2;
                        queue.offer(new Pair(newX, newY));
                        fresh--;
                    }
                }
            }   
            ans++;    
        }
        if(fresh > 0){
            return -1;
        }
        return ans-1;
    }
}