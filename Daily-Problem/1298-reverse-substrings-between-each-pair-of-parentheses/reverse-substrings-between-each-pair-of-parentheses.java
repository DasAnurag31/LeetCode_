class Solution {
    private void reverse(int left, int right, char[] arr){
        while(left < right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int n = s.length();
        char[] arr = s.toCharArray();
        int index = 0;
        while(index < n){
            if(arr[index] == '('){
                stack.add(index);
            }
            else if(arr[index] == ')'){
                reverse(stack.pop(), index, arr);
            }
            index++;
        }
        String ans="";
        for(char ch: arr){
            if(Character.isLetter(ch)){
                ans += ch + "";
            }  
        }
        return ans;
    }
}