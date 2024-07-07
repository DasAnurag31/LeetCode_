class Solution {
    public int numWaterBottles(int b, int e) {
        int count = b;
        while(b >= e){
            b -=  e;
            b += 1;
            count += 1;
        }
        return count;
    }
}