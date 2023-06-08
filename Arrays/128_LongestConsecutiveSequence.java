class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        int cmax = 0;
        for(int num : set){
            // Only operating on the smallest num of a sequence 
            if(!set.contains(num-1)){
                cmax = 1;
                int cnum = num;
                while(set.contains(cnum+1)){
                    cnum++;
                    cmax++;
                }
            }
            max = Math.max(max,cmax);
        }
        return max;
    }
}
