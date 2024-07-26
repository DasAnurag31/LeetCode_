class Solution {
    public List<String> letterCasePermutation(String s) {
        int n = s.length();
        int p = 1<<n;
        
        List<String> ans = new ArrayList<>();
        ans.add(s);
        
        for(int i=1; i<p;i++){
            String res = "";
            for(int j=0;j<n;j++){
                int v = (1<<j);
                if((i&v)>=1){
                    if(s.charAt(j)>='a' && s.charAt(j)<='z'){
                        res += (char)('A' + s.charAt(j)-'a');
                    } else if(s.charAt(j)>='A' && s.charAt(j)<='Z'){
                        res += (char)('a' + s.charAt(j)-'A');
                    } else res += s.charAt(j);
                } else res += s.charAt(j);
            }
            ans.add(res);
        }
        return new ArrayList(new HashSet(ans));
    }
}