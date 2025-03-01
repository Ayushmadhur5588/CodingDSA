import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.LinkedList;

public class l005 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Node {
        int data = 0;
        Node left = null;
        Node right = null;

        Node(int data) {
            this.data = data;
        }
    }

    public static int size(TreeNode root) {
        return root == null ? 0 : size(root.left) + size(root.right) + 1;
    }

    public static int height(TreeNode root) {
        return root == null ? -1 : Math.max(height(root.left), height(root.right)) + 1;
    }

    public static int diameter_01(TreeNode root) {
        if (root == null)
            return 0;
        int ld = diameter_01(root.left);
        int rd = diameter_01(root.right);

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(Math.max(ld, rd), lh + rh + 2);
    }

    // {diameter,height}
    public static int[] diameter_02(TreeNode root) {
        if (root == null) {
            return new int[] { 0, -1 };
        }

        int[] lp = diameter_02(root.left);
        int[] rp = diameter_02(root.right);

        int[] myAns = new int[2];
        myAns[0] = Math.max(Math.max(lp[0], rp[0]), lp[1] + rp[1] + 2);
        myAns[1] = Math.max(lp[1], rp[1]) + 1;

        return myAns;
    }

    public static int diameter_03(TreeNode root, int[] dia) {
        if (root == null)
            return -1;

        int lh = diameter_03(root.left, dia);
        int rh = diameter_03(root.right, dia);

        dia[0] = Math.max(dia[0], lh + rh + 2);

        return Math.max(lh, rh) + 1;
    }

    // 112
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0 ? true : false;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);

    }

       // 113
       public void pathSum(TreeNode root, int targetSum, List<Integer> smallAns, List<List<Integer>> ans) {
        if (root == null)
            return;

        if (root.left == null && root.right == null && targetSum - root.val == 0) {
            List<Integer> base = new ArrayList<>(smallAns);
            base.add(root.val);
            ans.add(base);
            return;
        }

        smallAns.add(root.val);

        pathSum(root.left, targetSum - root.val, smallAns, ans);
        pathSum(root.right, targetSum - root.val, smallAns, ans);

        smallAns.remove(smallAns.size() - 1);
    } 
}