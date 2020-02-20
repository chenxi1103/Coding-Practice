//////////////////////暴力解法///////////////////////
public class Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        ArrayList<Integer> all_nodes = new ArrayList<Integer>();
        helper(root, all_nodes);
        double min = Double.MAX_VALUE;
        int index = 0;
        for(;index<all_nodes.size(); index++){
            if(all_nodes.get(index) - target >= 0){
                break;
            }
        }
        if(index >= all_nodes.size()) return all_nodes.subList(all_nodes.size() - k, all_nodes.size());
        int left = index-1, right = index;
        for(int i = 0; i<k; i++){
            if(left >= 0 && (right >= all_nodes.size() || target - all_nodes.get(left) < all_nodes.get(right) - target)){
                result.add(all_nodes.get(left));
                left--;
            }else{
                result.add(all_nodes.get(right));
                right++;
            }
        }
        return result;
    }
    public void helper(TreeNode root, ArrayList<Integer> list){
        if(root == null) return;
        helper(root.left, list);
        list.add(root.val);
        helper(root.right,list);
    }
}
