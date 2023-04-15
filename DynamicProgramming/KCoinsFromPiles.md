# Maximum Values of K Coins From piles
## Algo:
* If there are n no of piles then
	* Either We take the Pile or not Take the pile 
	* If NOT TAKE :
		* decrease the no of piles 
	* If TAKE : 
		* Take the maximum no of coins 
			* Either 
	* Return MAX (Take , Not Take)
## Code:
```
class Solution {
    private Integer dp[][];
    private int helper(List<List<Integer>> piles, int currentPile, int coinsLeft){
        if(currentPile<0 || coinsLeft == 0)
            return 0;
        if(dp[currentPile][coinsLeft]!=null)
            return dp[currentPile][coinsLeft];

        int coinsPickLimit = Math.min(coinsLeft, piles.get(currentPile).size());

        //not including that currentPile, so coinsLeft remain same
        int excludeCurrentPile = helper(piles, currentPile-1, coinsLeft);
        
        int includeCurentPile=0;
        for(int j=0, sum=0; j<coinsPickLimit ; j++){
            sum+= piles.get(currentPile).get(j);
            //doing coinsLeft-(j+1) as we are starting from index 0 and coin picked cannot pe 0 if we pick it is > 0
            includeCurentPile = Math.max(sum + helper(piles, currentPile-1, coinsLeft-(j+1)), includeCurentPile);
        }
        
        int res = Math.max(includeCurentPile, excludeCurrentPile);
        dp[currentPile][coinsLeft] = res;
        return res;

    } 

    public int maxValueOfCoins(List<List<Integer>> piles, int K) {
        int n = piles.size();
        dp = new Integer[n + 1][K + 1];
        return helper(piles, n-1, K);
    }
```
