// https://leetcode.com/problems/assign-cookies/description/?envType=daily-question&envId=2024-01-01
import java.util.*;
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        int n = g.length;
        int m = s.length;
        int c = 0;
        while(j < m && i < n){
            if(g[i] <= s[j]){
                c++;
                i++;
                j++;
            }else{
                j++;
            }
        }
        return c;
    }
}