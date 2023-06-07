class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> map = new HashMap<>();
        String[] split = s.split(" ");
        if(split.length != pattern.length()){
            return false;
        }
        for(int i = 0;i < pattern.length();i++){
            char ch = pattern.charAt(i);
            String word = split[i];

            if(map.containsKey(ch)){
                String a = map.get(ch);
                if(!a.equals(word)){
                    return false;
                }
            }
            else{
                if(map.containsValue(word)){
                    return false;
                }
                map.put(ch,word);
            }
        }
        return true;
    }
}
