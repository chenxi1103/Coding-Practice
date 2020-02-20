class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if(curr != null) {
                    list.add(curr.val);
                    queue.offer(curr.left);
                    queue.offer(curr.right);
                } else {
                    list.add(0);
                }
            }
            for(int i = 0; i <= list.size() / 2; i++) {
                if(list.get(i) != list.get(list.size() - 1 - i)) return false;
            }
        }
        return true;
    }
}

//recursion的做法
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode Left, TreeNode Right) {
        if(Left == null || Right == null) {
            return Left == Right;
        }
        if(Left.val != Right.val) return false;
        return helper(Left.left, Right.right) && helper(Left.right, Right.left);
    }
}
