//怎么construct bst，怎么find level，怎么算distance，都忘记了…
//要我说二叉树依旧是没有拿下，recursion依旧不会写…好气哦…
public class Solution {
    /**
     * @param numbers: the given list
     * @param node1: the given node1
     * @param node2: the given node2
     * @return: the distance between two nodes
     */
    public int bstDistance(int[] numbers, int node1, int node2) {
        // Write your code here
        if(numbers == null || numbers.length <= 1) return -1;
        HashSet<Integer> set = new HashSet<>();
        for(int num : numbers) set.add(num);
        if(!set.contains(node1) || !set.contains(node2)) return -1;
        TreeNode node = null;
        for(int i = 0; i < numbers.length; i++) {
            node = insert(node, numbers[i]);
        }
        return distance(node, node1, node2);

    }
    private int distance(TreeNode node, int v1, int v2) {
        if(Math.max(v1, v2) < node.val) {
            return distance(node.left, v1, v2);
        }else if(Math.min(v1, v2) > node.val) {
            return distance(node.right, v1, v2);
        }
        return findLevel(node, v1) + findLevel(node, v2);
    }
    private int findLevel(TreeNode node, int val) {
        if(node.val == val) return 0;
        if(node.val < val) return findLevel(node.right, val) + 1;
        else return findLevel(node.left, val) + 1;
    }
    private TreeNode insert(TreeNode node, int val) {
        if(node == null) return new TreeNode(val);
        if(node.val < val) {
            node.right = insert(node.right, val);
        } else {
            node.left = insert(node.left, val);
        }
        return node;
    }
}
