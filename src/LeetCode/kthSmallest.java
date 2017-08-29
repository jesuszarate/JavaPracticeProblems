package LeetCode;

/**
 * Created by jesuszarate on 8/10/17.
 */
public class kthSmallest {

    public static TreeNode root;

    public static void main(String[] a) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        System.out.println((kthSmallest(root, 2)));
    }

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static int ck = 0;

    public static int kthSmallest(TreeNode root, int k) {
        TreeNode sm = kthSmallestN(root, k);
        return sm != null ? sm.val : 1;
    }

    public static TreeNode kthSmallestN(TreeNode current, int k) {

        TreeNode ln = null;
        TreeNode rn = null;
        if (current.left != null) {
            ln = kthSmallestN(current.left, k);
        }
        ck++;

        if (k == ck) return current;

        if (current.right != null) {
            rn = kthSmallestN(current.right, k);
        }

        return ln != null ? ln : rn;
    }


}
