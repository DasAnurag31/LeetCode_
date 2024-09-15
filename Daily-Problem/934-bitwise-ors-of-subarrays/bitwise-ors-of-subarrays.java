class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        //hashset stores the entire result
        HashSet<Integer> hashset = new HashSet<>();
        //preset used to keep track of only the previou reslults bcz we should not 
        //apply the "or" on completee hashset bcz it is a sub array and the elements taken need to be continuous
        HashSet<Integer> preset=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            int currnum=arr[i];
            //this is just used to store the new values for a single iteration 
            //bcz the set we are working on should not be simultaneously updated
            HashSet<Integer> helper = new HashSet<>();
            //take value from preset and compute "or" with the currnumber 
            //add the results to the helper set
            helper.add(currnum);
            for(Integer value : preset){
                helper.add(value | currnum);
            }
            //add the new resluts to the hashset
            for(Integer val : helper){
                hashset.add(val);
            }
            //update the preset with the recently computed set(i.e. helper)
            preset=helper;
        }
        return hashset.size();
    }
}