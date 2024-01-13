class Solution {
    private boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
            return true;
        }
        return false;

    }
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int count = 0;
        int i = 0;
        for(char ch:s.toCharArray()){
            if(i < n/2 && isVowel(ch)){
                count++;
            }if(i >= n/2 && isVowel(ch)){
                count--;
            }
            i++;
        }
        return count == 0;
    }
}

// https://leetcode.com/problems/determine-if-string-halves-are-alike/?envType=daily-question&envId=2024-01-12