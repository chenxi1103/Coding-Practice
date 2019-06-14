class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<TreeNode>();
        return generate(1, n);
    }
    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if(start > end) {
            list.add(null);
            return list;
        }
        for(int i = start; i <= end; i++) {
            List<TreeNode> Left = generate(start, i-1);
            List<TreeNode> Right = generate(i+1, end);
            for(TreeNode l : Left) {
                for (TreeNode r : Right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
