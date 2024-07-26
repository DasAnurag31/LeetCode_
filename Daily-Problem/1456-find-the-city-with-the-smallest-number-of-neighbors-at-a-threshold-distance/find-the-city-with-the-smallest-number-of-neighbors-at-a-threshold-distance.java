public class Solution {

    public int findTheCity(int n, int[][] e, int t) {
        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = (int) (1e9);
            }
        }

        for (int[] edge : e) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            d[u][v] = w;
            d[v][u] = w;
        }

        for (int i = 0; i < n; i++) {
            d[i][i] = 0;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (d[i][k] != (int) (1e9) && d[k][j] != (int) (1e9)) {
                        d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                    }
                }
            }
        }

        int minReach = n;
        int bestCity = -1;

        for (int i = 0; i < n; i++) {
            int reach = 0;
            for (int j = 0; j < n; j++) {
                if (d[i][j] <= t) {
                    reach++;
                }
            }
            if (reach <= minReach) {
                minReach = reach;
                bestCity = i;
            }
        }

        return bestCity;
    }
}
