public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        String maxStr = ""; 

        for (double i = 0; i < s.length(); i += 0.5) {
            int left = (int) Math.floor(i);
            int right = (int) Math.ceil(i);

            String palindrome = expandFromCenter(s, left, right);
            if (palindrome.length() > maxStr.length()) {
                maxStr = palindrome;
            }
        }

        return maxStr;
    }

    private String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}