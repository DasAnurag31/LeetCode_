class Solution {
    public int firstUniqChar(String s) {
        HashSet<Character> set = new HashSet<>();
        for(char ch:s.toCharArray()){
            if(set.contains(ch)){
                set.remove(ch);
                set.add(Character.toUpperCase(ch));
            }
            else if(set.contains(Character.toUpperCase(ch))){
                continue;
            }
            else{
                set.add(ch);
            }
        }
        int i=0;
        for(char ch:s.toCharArray()){
            if(set.contains(ch)){
                return i;
            }
            i++;
        }
        return -1;
    }
}