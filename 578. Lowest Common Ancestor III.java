public class Solution {
    
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        
        if (!(find(root, A) && find(root, B))) return null; //不同时存在AB节点，返回null
        if (find(root.left, A) && find(root.left, B)) return lowestCommonAncestor3(root.left, A, B); //AB出现在左
        if (find(root.right, A) && find(root.right, B)) return lowestCommonAncestor3(root.right, A, B); //AB在右
        return root;  //其余情况答案均为root
        
    }
    
    public boolean find(TreeNode root, TreeNode node) {         //直观的查找节点
        if (root == null) return false;
        if (root == node) return true;
        
        return (find(root.left, node) || find(root.right, node));
    }
}

//自己参考答案写出来的肥肠简短的程序（哈哈），比他们都简单！
