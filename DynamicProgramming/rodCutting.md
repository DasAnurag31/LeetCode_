# Rod Cutting
## Algo :
* Start Cutting from the left and cut from 1 to n pieces and find the remaining from recursively calling the problem
## Code :
```
int rod(int[] prices,int n,int dp[]){
    // base case
    if(n<=0)
        return 0;

    // lookup case
    if(dp[n]!=0)
        return dp[n];

    // recursive case
    int ans = INT_MIN;
    for (int i = 0; i < n;i++){
        int cut = i + 1; // done as the index is 0 based 
        int current_ans =  prices[i]+rod(prices,n-cut,dp);
        ans = max(ans, current_ans); 
    }

    return dp[n]=ans;
}
```
