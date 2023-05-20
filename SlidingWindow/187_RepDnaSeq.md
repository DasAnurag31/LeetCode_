# Rep-DNA-Seq  | Sliding Window
## Algo:
* Keep storing every 10 length substring we see in a SET
* If at any point we encounter the substring to be stored in the SET we store it in a result set
* If while storing in result set, it is not already found in the result set, then we list it in the ans list

## Code:
```
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        if(s.length()<10) return ans;
        HashSet<String> set = new HashSet<>();
        HashSet<String> result=new HashSet<>();
        set.add(s.substring(0,10));
        for(int i = 1;i < s.length()-9;i++){
            String substring = s.substring(i,i+10);
            if(set.contains(substring)){
                if(!result.contains(substring)){
                    ans.add(substring);
                }
                result.add(substring);
            }
            set.add(substring);
        }
        return ans;
    }
}
```
