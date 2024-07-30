class Solution {
    public int minimumDeletions(String s) {
        int countA=0;
        int countB=0;
        int[] preB=new int[s.length()];
        int[] postA=new int[s.length()];
        char[] ss=s.toCharArray();
        for(int i=0;i<ss.length;i++){
             if(ss[i]=='b'){
                countB++;
            }
            preB[i]=countB;
           
        }
        for(int i=postA.length-1;i>=0;i--){
            if(ss[i]=='a'){
                countA++;
            }
            postA[i]=countA;
            
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<ss.length;i++){
            int totalCost=preB[i]+postA[i]-1;
            ans=Math.min(totalCost,ans);
        }
        return ans;
    }
}

