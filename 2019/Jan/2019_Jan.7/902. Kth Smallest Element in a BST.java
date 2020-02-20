/////////////////////////懒人方法：容易想但是效率低//////////////////////////////
public class Solution {
    /**
     * @param root: the given BST
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    ArrayList<Integer> list = new ArrayList<>();
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        // write your code here
        helper(root, k);
        return list.get(k-1);
    }
    public void helper(TreeNode root, int k){
        if(root == null) return;
        helper(root.left, k);
        if(count == k) return;
        list.add(root.val);
        count++;
        helper(root.right, k);
    }
}

/////////////////////////聪明有效率的方法 (有效率体现在再次查找时会非常快) - child count//////////////////////
public class Solution {
    /**
     * @param root: the given BST
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    public int kthSmallest(TreeNode root, int k) {
        // write your code here
        HashMap<TreeNode, Integer> map = new HashMap<>();
        int all_children = countChildren(root, map);
        return quickSelect(root, k, map);
    }
    public int countChildren(TreeNode root, HashMap<TreeNode, Integer> map){
        if(root == null) return 0;
        int left_children = countChildren(root.left, map);
        int right_children = countChildren(root.right, map);
        int root_children = left_children + right_children + 1;
        map.put(root, root_children);
        return left_children + right_children + 1;
    }
    public int quickSelect(TreeNode root, int k, HashMap<TreeNode, Integer> map){
        if(root == null) return -1;
        int left = root.left == null ? 0 : map.get(root.left);
        if(left + 1 == k) return root.val;
        if(left >= k) return quickSelect(root.left, k, map);
        return quickSelect(root.right, k - left - 1, map);
    }
}
