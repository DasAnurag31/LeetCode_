class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int ans = -1;
        int n = bloomDay.length;
        if(m * k > n){
            return ans;
        }

        int max = Arrays.stream(bloomDay).max().getAsInt();
        int left = 0, right = max;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(isPossible(mid, bloomDay, k, m)){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return ans;
    }
    private boolean isPossible(int mid, int bloomDay[], int k, int req){
        int bcount = 0, fcount = 0;
        for(int day : bloomDay){
            if(day <= mid){
                fcount++;
            }else{
                fcount = 0;
            }
            if(fcount == k){
                fcount = 0;
                bcount++;
            }
        }
        return bcount >= req;
    }
}