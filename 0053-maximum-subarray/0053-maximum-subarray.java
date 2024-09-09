class Solution {
    public int maxSubArray(int[] nums) {
        int local = 0;
        int global = Integer.MIN_VALUE;
        for(int num:nums){
            if(num >= local+num){
                local = num;
            }else{
                local += num;
            }
            global = Math.max(local, global);
        }
        global = Math.max(local, global);
        return global;
    }
}