class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n=startTime.length;
        int[][] events=new int[n][3];
        for(int i=0;i<n;i++){
            events[i][0]=startTime[i];
            events[i][1]=endTime[i];
            events[i][2]=profit[i];
        }

        Arrays.sort(events,(a,b)->Integer.compare(a[0], b[0]));
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return dfs(events,0,n,dp);
    }
    
    public int dfs(int[][] events, int idx, int n,int[] dp){
        if(idx == n){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int nextIdx=findNext(events, idx,n);
        int pick=events[idx][2]+dfs(events, nextIdx, n,dp);
        int notPick=dfs(events, idx+1, n,dp);
        return dp[idx]= Math.max(pick,notPick);
    }
    public int findNext(int[][] events, int idx, int n){
        int ans=n;
        int l=idx+1;
        int r=n-1;
        while(l<=r){
            int mid=(l+r)>>1;
            if(events[idx][1]<=events[mid][0]){
                ans=mid;
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return ans;
    }
}