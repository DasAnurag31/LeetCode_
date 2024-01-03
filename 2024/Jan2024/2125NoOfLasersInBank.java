class Solution {
    private int count(String s){
        int count = 0;
        for(char ch : s.toCharArray()){
            if(ch == '1'){
                count++;
            }
        }
        return count;
    }
    public int numberOfBeams(String[] bank) {
        int ans = 0;
        int prev = 0;
        for(String s : bank){
            if(prev == 0){
                prev = count(s);
            }else{
                if(count(s) > 0){
                    ans += prev * count(s);
                    prev = count(s);
                }
            }
        }
        return ans;
    }
}