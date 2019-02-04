//二叉树的序列化和反序列化，重点在反序列化上！！！不会做，再复习！
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        String result = "";
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size; i++){
                TreeNode currNode = queue.poll();
                if(currNode != null){
                    result += currNode.val;
                    queue.offer(currNode.left);
                    queue.offer(currNode.right);
                }else{
                    result += "#";
                }
                if(queue.size() != 0) result += ",";
            }
        }
        return result;
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data == null || data.length() == 0) {
            return null;
        }

        String[] val = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(val[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeftChild = true;
        for (int i = 1; i < val.length; i++) {
            if (!val[i].equals("#")) {
                TreeNode child = new TreeNode(Integer.parseInt(val[i]));
                if(isLeftChild){
                    queue.peek().left = child;
                }else{
                    queue.peek().right = child;
                }
                queue.offer(child);
            }else{
                if(isLeftChild){
                    queue.peek().left = null;
                }else{
                    queue.peek().right = null;
                }
            }
            if (!isLeftChild) {
                queue.poll();
            }
            isLeftChild = !isLeftChild;
        }
        return root;
    }
}
