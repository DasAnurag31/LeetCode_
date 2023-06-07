# Isomorphic Strings
## Algo:
* The key point is that if A->B then A can only map to B and B should not be mapped by any other characte than A and if all the characters in the two string map according to this, we can say they are isomorphic
* We need to check the Map from both sides 
* So we check if a is present then we check if the value in the is the value in b 
* If a is not present then we need to know that b is no where present in the map 

## Code:
```
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            if(!map.containsKey(s.charAt(i)))
            {   
                // if it does not contan the key it should not contain the value it maps either as any other keys value
                if(map.containsValue(t.charAt(i)))
                {
                    return false;
                }
                map.put(s.charAt(i),t.charAt(i));
            }
            else
            {
                if(map.get(s.charAt(i)) != t.charAt(i))
                {
                    return false;
                }
            }
        }
        return true;
    }
}
```
