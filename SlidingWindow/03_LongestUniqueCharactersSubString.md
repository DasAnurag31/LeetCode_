# LongestSubstring no Character Repeat
## Algo:
* Maintain a set as set only have unique characters and in order of insertion
* Check if the charater at the end pointer is in the set 
* Keep removing characters until there are no dublicates
* Add the character at the end pointer
## Code:
```
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Set<Character> set = new LinkedHashSet<>();
        int start = 0;
        int end = 0;
        while(end < s.length())
        {
            char ch = s.charAt(end);
            while(set.contains(ch)){
                set.remove(s.charAt(start));
                start++;
            }
            set.add(ch);
            max = Math.max(max, end-start+1);
            end++;
        }
        return max;   
    }
}
```
