class Solution {
    private String reverse(String s){
        StringBuilder str = new StringBuilder(s);
        str.reverse();
        return str.toString();
    }
    public String getEncryptedString(String s, int k) {
        int n = s.length();
        k = k % n;
        s = reverse(s);
        return reverse(s.substring(0,n-k)) + reverse(s.substring(n-k));
    }
}