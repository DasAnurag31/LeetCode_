class Solution {
    public String reverseWords(String s) {
        s = " " + s;
        int left = s.length() - 1;
        int right = s.length() -1;
        StringBuilder str = new StringBuilder();
        while(left > 0){
            while(left >0 && s.charAt(left) == ' '){
                left--;
            }
            right = left;
            while(left >0 && s.charAt(left) != ' '){
                left--;
            }
            str.append(s.substring(left+1,right+1));
            str.append(" ");
        }
        return str.toString().trim();
    }
}