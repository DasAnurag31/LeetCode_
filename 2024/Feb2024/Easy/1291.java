class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        if(low >= high){
            return ans;
        }
        int num = 12;
        int prev = 12;
        int factor = 11;
        int i = 3;
        while(num < low){
            int temp = num + factor;
            if(temp % 10 == 0){
                num = prev * 10 + i;
                prev = num;
                factor = factor * 10 + 1;
                i++;
            }else{
                num += factor;
            }
        }
        while(num >= low && num <= high){
            ans.add(num);
            int temp = num + factor;
            if(temp % 10 == 0){
                num = prev * 10 + i;
                prev = num;
                factor = factor * 10 + 1;
                i++;
            }else{
                num += factor;
            }
        }
        return ans;
    }
}