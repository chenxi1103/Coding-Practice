package BinaryTreeSummary;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
public class BTsummary{
  //TreeNode Class
  private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}

  public static void main(String[] args) {
      TreeNode r1 = new TreeNode(1);
      TreeNode r2 = new TreeNode(2);
      TreeNode r3 = new TreeNode(3);
      TreeNode r4 = new TreeNode(4);
      TreeNode r5 = new TreeNode(5);
      TreeNode r6 = new TreeNode(6);
      r1.left = r2;
      r1.right = r3;
      r2.left = r4;
      r2.right = r5;
      r3.right = r6;

      BTsummary bTsummary = new BTsummary();
      System.out.println("1. Count node by recursive method: " + bTsummary.getTreeNodes1(r1));
      System.out.println("2. Count node by travesal method: " + bTsummary.getTreeNodes2(r1));
      System.out.println("3. Get Binary Tree Depth by recursive method: " + bTsummary.getDepth1(r1));
      System.out.println("4. Get Binary Tree Depth by travesal method: " + bTsummary.getDepth2(r1));
      System.out.println("5. Binary Pre-Order travesal by recursive method: " + bTsummary.preOrder1(r1).toString());
      System.out.println("6. Binary Pre-Order travesal by non-recursive method: " + bTsummary.preOrder2(r1).toString());
      System.out.println("7. Binary In-Order travesal by recursive method: " + bTsummary.inOrder1(r1).toString());
      System.out.println("8. Binary In-Order travesal by non-recursive method: " + bTsummary.inOrder2(r1).toString());
      System.out.println("9. Binary Post-Order travesal by recursive method: " + bTsummary.postOrder1(r1).toString());
      System.out.println("10. Binary Post-Order travesal by non-recursive method: " + bTsummary.postOrder2(r1).toString());

}

  /*
   * 1. Count nodes - recursion
   * Time Complexity: o(n)
   */
  public int getTreeNodes1(TreeNode root){
    if(root == null) return 0;
    return getTreeNodes1(root.left)+getTreeNodes1(root.right)+1;
  }

  /*
   * 2. Count nodes - non-recursion
   * Time Complexity: o(n)
   */
  public int getTreeNodes2(TreeNode root){
    if(root == null) return 0;
    Queue q = new LinkedList<TreeNode>();
    q.offer(root);
    int count = 1;
    while(!q.isEmpty()){
      TreeNode temp = (TreeNode) q.poll();
      if(temp.left!=null){
        q.offer(temp.left);
        count++;
      }
      if(temp.right != null){
        q.offer(temp.right);
        count++;
      }
    }
    return count;
  }

  /*
   * The depth of the binary tree - Recursion
   * Time Complexity - o(n)
   */
  public int getDepth1(TreeNode root) {
      if(root == null) return 0;
      return Math.max(getDepth1(root.left), getDepth1(root.right))+1;
  }
  /*
   * The depth of the binary tree - travesal (non-recursion)
   * Time Complexity - o(n)
   */
  public int getDepth2(TreeNode root) {
      if(root == null) return 0;
      int depth = 0;
      int currNumOfNodes = 1;
      int nextNumOfNodes = 0;
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      while(!queue.isEmpty()) {
          TreeNode currNode = queue.poll();
          currNumOfNodes--;
          if(currNode.left!=null) {
              queue.offer(currNode.left);
              nextNumOfNodes++;
          }
          if(currNode.right!=null) {
              queue.offer(currNode.right);
              nextNumOfNodes++;
          }
          if(currNumOfNodes == 0) {
              depth++;
              currNumOfNodes = nextNumOfNodes;
              nextNumOfNodes = 0;
          }
      }
      return depth;
  }

  /*
   * Preorder Travesal of Binary Tree - recursive
   * Time complexity: o(n)
   */
  public ArrayList<Integer> preList = new ArrayList<>();
  public List<Integer> preOrder1(TreeNode root){
      if(root == null) return preList;
      preList.add(root.val);
      preOrder1(root.left);
      preOrder1(root.right);
      return preList;
  }

  /*
   * Preorder Travesal of Binary Tree - nonrecursive
   * Time complexity: o(n)
   */
  public List<Integer> preOrder2(TreeNode root){
      List<Integer> result = new ArrayList<>();
      if(root == null) return result;
      Stack<TreeNode> stack = new Stack<>();
      stack.push(root);
      while(!stack.isEmpty()) {
          TreeNode temp = stack.pop();
          result.add(temp.val);
          //Remember we first push right child then push left child since we are using stack
          if(temp.right!=null) {
              stack.push(temp.right);
          }
          if(temp.left!=null) {
              stack.push(temp.left);
          }
      }
      return result;
  }

  /*
   * Inorder Travesal of Binary Tree - recursive
   * Time complexity: o(n)
   */
  public List<Integer> inList = new ArrayList<>();
  public List<Integer> inOrder1(TreeNode root){
      if(root == null) return inList;
      inOrder1(root.left);
      inList.add(root.val);
      inOrder1(root.right);
      return inList;
  }

  /*
   * Inorder Travesal of Binary Tree - inrecursive
   * Time complexity: o(n)
   */
  public List<Integer> inOrder2(TreeNode root){
      List<Integer> result = new ArrayList<>();
      if(root == null) return result;
      Stack<TreeNode> stack = new Stack<>();
      //First push all the left child into stack
      while(root!=null) {
          stack.push(root);
          root = root.left;
      }
      while(!stack.isEmpty()) {
          TreeNode temp = stack.pop();
          result.add(temp.val);
          if(temp.right!=null) {
              TreeNode tempRight = temp.right;
              while(tempRight!=null) {
                  stack.push(tempRight);
                  tempRight = tempRight.left;
              }
          }
      }
      return result;
  }

  /*
   * Inorder Travesal of Binary Tree - recursive
   * Time complexity: o(n)
   */
  public List<Integer> postList = new ArrayList<>();
  public List<Integer> postOrder1(TreeNode root){
      if(root == null) return postList;
      postOrder1(root.left);
      postOrder1(root.right);
      postList.add(root.val);
      return postList;
  }

  /*
   * Inorder Travesal of Binary Tree - nonrecursive
   * Time complexity: o(n) + o(n)
   * This is not the best solution since result.add(0,temp.val) make it slow.
   * Everytime ArrayList needs to shift everything to the right. Not good :(
   * But this version is concise. The equivalent way is to do result.add(temp.val)
   * and use Collections.sort(result) at the end of the program
   */
  public List<Integer> postOrder2(TreeNode root){
      List<Integer> result = new ArrayList<>();
      if(root == null) return result;
      Stack<TreeNode> stack = new Stack<>();
      stack.push(root);
      while(!stack.isEmpty()) {
          TreeNode temp = stack.pop();
          result.add(0,temp.val);
          if(temp.left!=null) {
              stack.push(temp.left);
          }
          if(temp.right!=null) {
              stack.push(temp.right);
          }
      }
      return result;
  }
}
