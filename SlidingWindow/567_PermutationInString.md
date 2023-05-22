# Permutation in String | Sliding
## Algo:
* Map the frequency of s1 
* Create a map for the window for s2
* Slide the window and see if the window matches 
* When the size of the window equals after checking the match remove the left ele from teh window
## Code:
```
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        for(int i = 0 ; i < s1.length() ; i++){
            char ch = s1.charAt(i);
            map.put(ch , map.getOrDefault(ch,0)+1);
        }
        int left = 0;
        int right = 0;
        while(right < s2.length()){
            char a = s2.charAt(right);
            right++;   
            window.put(a, window.getOrDefault(a,0)+1);
            if(window.equals(map)){
                return true;
            }
            if(right - left == s1.length()){
                if(window.get(s2.charAt(left)) > 1){
                    window.put(s2.charAt(left),window.get(s2.charAt(left)) - 1);
                }   
                else if (window.get(s2.charAt(left)) == 1){
                    window.remove(s2.charAt(left));
                }
                left++;
            }
        }
        return false;
    }
}
```
