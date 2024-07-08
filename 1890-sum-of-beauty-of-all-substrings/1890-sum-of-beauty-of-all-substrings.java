class Solution {
    public int beautySum(String s) {
        int sum = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int[] charFreq = new int[26];            
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                charFreq[c - 'a']++;
                sum += beautySum(charFreq);
            }
        }
        
        return sum;
    }
    
    private int beautySum(int[] charFreq) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int i : charFreq) {
            if (i != 0) {
                max = Math.max(max, i);
                min = Math.min(min, i);
            }
        }
        
        return max - min;
    }
}