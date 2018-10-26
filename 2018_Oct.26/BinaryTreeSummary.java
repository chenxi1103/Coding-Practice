import java.util.ArrayList;
import java.util.Iterator;
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

  //1. Count nodes - recursion
  public int getTreeNodes(TreeNode root){
    if(root == null) return 0;
    return getTreeNodes(root.left)+getTreeNodes(root.right)+1;
  }

  //2. Count nodes - non-recursion
  public int getTreeNodes(TreeNode root){
    int count = 0;
    if(root == null) return count;
    Queue q = new LinkedList<TreeNode>();
    q.offer(root);
    while(!q.isEmpty()){
      TreeNode temp = q.poll();
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
}
