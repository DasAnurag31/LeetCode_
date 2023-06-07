class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            if(!map.containsKey(s.charAt(i)))
            {   
                // if it does not contan the key it should not contain the value it maps either as any other keys value
                if(map.containsValue(t.charAt(i)))
                {
                    return false;
                }
                map.put(s.charAt(i),t.charAt(i));
            }
            else
            {
                if(map.get(s.charAt(i)) != t.charAt(i))
                {
                    return false;
                }
            }
        }
        return true;
    }
}
