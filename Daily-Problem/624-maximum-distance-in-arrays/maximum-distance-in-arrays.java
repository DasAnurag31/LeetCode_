class Solution {
    public int maxDistance(List<List<Integer>> arr) {
        int m = arr.size();
        int min = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;
        int minIndex = -1;
        int maxIndex = -1;

        for(int i=0;i<m;i++){
            List<Integer> a = arr.get(i);
            int index = i;

            if(a.get(0) < min){
                smin = min;
                min = a.get(0);
                minIndex = i;
            }
            else{
                if(a.get(0) < smin){
                    smin = a.get(0);
                }
            }      

            if(a.get(a.size() - 1) > max){
                smax = max;
                max = a.get(a.size() - 1);
                maxIndex = i;
            }else{
                if(a.get(a.size() - 1) > smax){
                    smax = a.get(a.size() - 1);
                }
            }
        }

        if(minIndex != maxIndex){
            return Math.abs(min - max);
        }
        return Math.max(
            Math.abs(min - smax),
            Math.abs(smin - max)
        );
    }
}