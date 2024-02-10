class Solution {
    private boolean isValid(String s){
        int n = s.length();
        for(int i=0;i<=n/2;i++){
            if(s.charAt(i) != s.charAt(n-1-i)){
                return false;
            }
        }
        return true;
    }
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                String ss = s.substring(i,j+1);
                if(isValid(ss)){
                    count++;
                }
            }
        }
        return count;
    }
}