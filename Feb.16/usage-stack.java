class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if(stack.size() == 0) {
                stack.push(currChar);
                continue;
            }
            if((currChar == ')' && stack.peek() == '(') || (currChar == ']' && stack.peek() == '[') || (currChar == '}' && stack.peek() == '{')) {
                stack.pop();
                continue;
            } else {
                stack.add(currChar);
            }
        }
        return stack.isEmpty();
    }
}
