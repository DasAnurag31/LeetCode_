# Two Pointer
## Concept 
* Draw a graph to get an easier understanding
* When the prices rise then see if the max is greater than the price rise and leave the left poiner there
* If the Price is less then Move the left to the new lowest
* In Both cases keep moving the right pointer

Code:
```
class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int start = 0;
        int end = 1;
        while(end < prices.length){
            if(prices[start] < prices[end]){
                max = Math.max(max,prices[end] - prices[start]);
            }
            else{
                start = end;
            }
            end++;
        }
        return max;
    }
}
```
