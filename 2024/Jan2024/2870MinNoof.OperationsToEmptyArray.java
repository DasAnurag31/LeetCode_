class Solution {
    public int minOperations(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int num:nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int value = entry.getValue();
            if(value == 1){
                return -1;
            }
            if(value % 3 == 0){
                count += value/3;
            }
            else if(value % 3 == 2){
                count += value/3 + 1;
            }
            else if(value % 3 == 1){
                count += value/3 + 1;
            }
        }
        return count;
    }
}