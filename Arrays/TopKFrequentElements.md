# Top K frequent Element
## Algo:
## Code:
```

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new LinkedHashMap<>();
        ArrayList<Integer> list =new ArrayList<>();
        int result[]=new int[k];
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }   
        for(Map.Entry<Integer,Integer>e:map.entrySet()){
            list.add(e.getValue());
        }
        Collections.sort(list);
        int end=list.size()-1;
        for(int i=0;i<result.length;i++){
            for(Map.Entry<Integer,Integer>e:map.entrySet()){
                if(list.get(end)==e.getValue()){
                    result[i]=e.getKey();
                    map.remove(e.getKey());
                    end--;
                    break;
                }
            }
        }
        return result;
    }
}
```
