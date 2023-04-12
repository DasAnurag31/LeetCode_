# Simplify File Path | String
## Algo 
* Split the Entire String into an array fo strings with the seperator ```/```
* `.` -> same folder so do nothing 
* `""`  -> no Filename so do nothing
* `".."` -> go up one directory so pop
* `"abc "` -> Treate as a directory and push

## Code:
```
class Solution {
    public String simplifyPath(String path) {
        String[] fullpath = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String part : fullpath){
            if(part.equals("")||part.equals(".")){
                continue;
            }
            if(part.equals("..")){
                if(!stack.isEmpty())
                stack.pop();
            }
            else{
                stack.push(part);
            }
        }
        String result="";
        while(!stack.isEmpty()){
            result="/"+stack.pop()+result;
        }
        if(result.equals("")) return "/";
        return result;
    }
}
```
