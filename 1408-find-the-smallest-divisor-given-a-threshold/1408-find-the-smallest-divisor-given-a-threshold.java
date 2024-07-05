class Solution {
    boolean can(int[]nums, int threshold, int div){
     int sum = 0;
     for(int i=0;i<nums.length;i++){
        sum +=Math.ceil(nums[i]/(double)div);

     }
     return sum <= threshold;
}
    public int smallestDivisor(int[] nums, int threshold) {
        int l =1, r= 1000_000 , ans = 0;
        while(l<=r){
            int mid = l + ((r-l)/2);
            if(can(nums,threshold,mid)){
                ans = mid;
                r = mid - 1;
            }
            else l = mid + 1;
        }
        return ans;
    }
}