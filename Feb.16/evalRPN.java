class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+") || tokens[i].equals("-") ||tokens[i].equals("/") || tokens[i].equals("*")) {
                int first = stack.pop();
                int second = stack.pop();
                int op = 0;
                if (tokens[i].equals("+")) {
                    op = first + second;
                } else if (tokens[i].equals("-")) {
                    op = second - first;
                } else if(tokens[i].equals("/")) {
                    op = second / first;
                } else {
                    op = second * first;
                }
                stack.add(op);
            } else {
                stack.add(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }
}
