# Find All Anagrams
## Concept
* Create Two maps
* Map one will comntain the characters and their no in the given string Anagram
* Map Two will contain the characters and their count in the sliding window
* loop until end of window reaches length of string
	* add the right 
	* check if window is equal to anagram map
	* when length is equal shorten the start of the window 
		* While shortening the window if the character count is 0 remove it from map to get perfect equals while comparing
## Code:
```
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int len = p.length();
        int left = 0,right = 0;
        List<Integer> result = new ArrayList<>();
        if(len > s.length()) return result;
        Map<Character,Integer> countS = new HashMap<>();
        Map<Character,Integer> countP = new HashMap<>();
        for(int i = 0; i < p.length(); i++) {
            countP.put(p.charAt(i),countP.getOrDefault(p.charAt(i),0) + 1);
        }
        while(right < s.length()){
            char rightChar = s.charAt(right);
            countS.put(rightChar, countS.getOrDefault(rightChar, 0) + 1);
            right++;
            if (countS.equals(countP)) {
                result.add(left);
            }
            if (right - left == p.length()) { //IMPORTANT
                char leftChar = s.charAt(left);
                if (countS.containsKey(leftChar)) {
                    countS.put(leftChar, countS.get(leftChar) - 1);
                    if (countS.get(leftChar) == 0) {
                        countS.remove(leftChar);
                    }
                }
                left++;
            }
        }
        return result;
    }
}
```
