# Minimum Cost to Make All Characters Equal | Greedy
## Algo :
* Itterate and check with the previous character 
* if changing all characters behind the present character is cheaper do it
* else change the characters from that to the n-i 
* keep adding the min at each point
## Code:
```
class Solution {
    public long minimumCost(String s) {
        long ans = 0;
        for(int i = 1;i < s.length();i++){
            if(s.charAt(i) != s.charAt(i-1))
            ans += Math.min(i,s.length()-i); 
        }
        return ans;
    }
}
```
