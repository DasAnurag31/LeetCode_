# Valid Parentheses
## Algo:
* Create a Stack and insert if opening brackets 
* Pop if exit brackets and match pair from current
* EDGE CASES:
	* closing brackets without open brackets
	* single bracket 
## Code:
```
class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        char open;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('|| ch == '{' || ch =='['){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty()) return false;
                open = stack.pop();
                if(open == '(' && ch == ')') continue;
                if(open == '{' && ch == '}') continue;
                if(open == '[' && ch == ']') continue;
                return false;
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}
```
