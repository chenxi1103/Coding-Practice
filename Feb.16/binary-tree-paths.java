class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null) return result;
        dfs(root, "", result);
        return result;
    }
    private void dfs(TreeNode root, String sb, List<String> list) {
        if(root == null) {
            list.add(sb);
            return;
        }
        if(!sb.equals("")) {
            sb += "->";
        }
        sb += root.val;
        String currStr = sb;
        //为什么要判断一下呢，因为递归的出口是，只要 == null的时候，就把字符串放入list里
        //那么有一些左孩子是null，右孩子依然右值的情况，就会在一条路还没有走完的情况下，就被加入list里了
        if(root.left != null && root.right != null) {
            dfs(root.left, sb, list);
            dfs(root.right, currStr, list);
        } else if (root.left == null) {
            dfs(root.right, currStr, list);
        } else {
            dfs(root.left, currStr, list);
        }
    }
}

///////////////////////////更聪明的做法///////////////////////////////
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null) return result;
        List<String> leftList = binaryTreePaths(root.left);
        List<String> rightList = binaryTreePaths(root.right);
        for(String str : leftList) {
            result.add(root.val + "->" + str);
        }

        for(String str : rightList) {
            result.add(root.val + "->" + str);
        }
        //这一步相当重要，是前面逻辑的基石！
        //当这个节点是叶子结点的时候，左右都是null，这样就不会进入前面两个for循环
        //这种情况下，result就是空的，什么都没有，但此时还是需要把这个单节点的value加进去的！
        if(result.size() == 0) {
            result.add(root.val + "");
        }
        return result;
    }
}
