class Solution {
    public boolean canAliceWin(int[] nums) {
        int a = 0;
        int b = 0;
        int c = 0;
        for(int num:nums){
            if(num < 10){
                a += num; 
            }
            else if(num >= 10 && num < 100){
                b += num;
            }
            else{
                c += num;
            }
        }
        return a > b+c || b > a+c;
    }
}