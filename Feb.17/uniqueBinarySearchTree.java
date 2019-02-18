class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<TreeNode>();
        return helper(1, n);
    }
    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if(start > end) {
            list.add(null);
            return list;
        }
        if(start == end) {
            list.add(new TreeNode(start));
            return list;
        }
        //这道题是理解recursion的好题，首先从1-n这n个数，任何一个数都可以作为根节点
        //所以要for loop，从start到end，每一个k都可以作为根节点，然后得到它的左右子树
        //把他们拼起来存进新的list里。这里要注意，left里的一个可以搭配right里的任意一个
        //所以这道题是三层loop，o（n^3)的时间复杂度
        for(int k = start; k <= end; k++) {
            List<TreeNode> leftList = helper(start, k - 1);
            List<TreeNode> rightList = helper(k + 1, end);
            for(int i = 0; i < leftList.size(); i++) {
                for (int j = 0; j < rightList.size(); j++) {
                    TreeNode currNode = new TreeNode(k);
                    currNode.left = leftList.get(i);
                    currNode.right = rightList.get(j);
                    list.add(currNode);
                }
            }
        }
        return list;
    }
}
