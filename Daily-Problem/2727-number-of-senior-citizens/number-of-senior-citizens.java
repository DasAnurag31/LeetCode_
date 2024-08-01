class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(String detail: details){
            int age = Integer.parseInt(detail.substring(11, detail.length() -2));
            count += age > 60 ? 1 : 0;
        }
        return count;
    }
}