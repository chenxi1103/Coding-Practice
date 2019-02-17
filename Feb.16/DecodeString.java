//这个题有点难的，不太会233
class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        Stack<Integer> stackNum = new Stack<>();
        stack.add("");
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                int start = i;
                while (Character.isDigit(s.charAt(i))) {
                    i++;
                }
                stackNum.add(Integer.parseInt(s.substring(start, i)));
                i--;
            } else if (ch == '[') {
                stack.add("");
            } else if (ch == ']') {
                String str = stack.pop();
                int num = stackNum.pop();
                StringBuilder temp = new StringBuilder();
                for(int j = 0; j < num; j++) {
                    temp.append(str);
                }
                stack.add(stack.pop() + temp.toString());
            } else {
                stack.add(stack.pop() + ch);
            }
        }
        return stack.pop();
    }
}
