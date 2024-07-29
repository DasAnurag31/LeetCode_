class Solution {
    public int numTeams(int[] rating) {
        int teams = 0;
        int n = rating.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if((long)(rating[j] - rating[i]) * (long)(rating[k] - rating[j]) > 0){
                        teams++;
                    }
                }
            }
        }
        return teams;
    }
}