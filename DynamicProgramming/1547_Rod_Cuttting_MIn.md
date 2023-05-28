# Rod Cutting MIN | DP
## ALGO:
* Form a Rec Tree
* Itterate through all the cut positions in cuts and try each cut if valid
* store the answers in dp
* see which of them is minimum
* return minimum
## Code:
```
class Solution {
    Map<ArrayList<Integer>, Integer> dp = new HashMap<>(); //(l,r)->min
    public int rodCut(int l, int r, int[] cuts){
        ArrayList<Integer> ind = new ArrayList<>();
        ind.add(l); ind.add(r);
        if(dp.containsKey(ind))
        {
            return dp.get(ind);
        } 
        int min = Integer.MAX_VALUE; // IMPORTANT
        if(r-l == 1) return 0;
        for(int index : cuts){
            if(index < r && index > l){
                min = Math.min(min,(r-l) + rodCut(l,index,cuts) + rodCut(index,r,cuts));
            }
        }
        if(min ==  Integer.MAX_VALUE){
            min = 0;
        }
        dp.put(ind, min);
        return min;
    }
    public int minCost(int n, int[] cuts) {
        return rodCut(0,n,cuts);
    }
}
```
