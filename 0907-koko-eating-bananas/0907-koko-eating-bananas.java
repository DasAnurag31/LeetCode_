class Solution {
    private boolean canEat(int[] piles, int n, int k, int h) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k;
            if (hours > h) {
                return false;
            }
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(piles[i], max);
        }
        if(n == h){
            return max;
        }
        int low = 1;
        int high = max;
        int ans = 0;
        while(low <= high){
            int mid = (low + high) / 2;
            if(canEat(piles, n, mid, h)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}