class Solution {
    public double myPow(double x, int n) {
        if(n >= Integer.MAX_VALUE){
            return (int)Math.abs(x) == 0 ? 0 : findPow(x , n);
        }
        else if(n <= Integer.MIN_VALUE){
            return (int)Math.abs(x) > 1 ? 0 : 1 / findPow(x , n);
        }
        double ans = findPow(x , n);
        return n > 0 ? ans : 1 / ans ;
    }

    public double findPow(double x ,int n){
        if(x == 0 || x == 1){
            return x;
        }
        else if(n % 2 == 0 && x == -1){
            return 1 ;
        }
        else if(n % 2 == 1 && x == -1){
            return -1 ;
        }
        else if(Math.abs(n) == 0){
            return 1.0;
        }
        return x * myPow(x , Math.abs(n) - 1);
    }
}