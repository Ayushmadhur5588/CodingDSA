import java.util.ArrayList;

public class l001 {
    public static class Node {
        int data = 0;
        Node left = null;
        Node right = null;

        Node(int data) {
            this.data = data;
        }
    }

    // Traversal
    public static void preOrder(Node node, ArrayList<Integer> ans) {
        if (node == null)
            return; // base case (left or right is null)

        ans.add(node.data);
        preOrder(node.left, ans);
        preOrder(node.right, ans);
    }

    public static void inOrder(Node node, ArrayList<Integer> ans) {
        if (node == null)
            return;

        inOrder(node.left, ans);
        ans.add(node.data);
        inOrder(node.right, ans);
    }

    public static void postOrder(Node node, ArrayList<Integer> ans) {
        if (node == null)
            return;

        postOrder(node.left, ans);
        postOrder(node.right, ans);
        ans.add(node.data);
    }

    // Basics

    public static int size(Node node) {

        if (node == null)
            return 0;
        return size(node.left) + size(node.right) + 1;

    }

    public static int height(Node node) {
        if (node == null)
            return -1;

        int left = height(node.left);
        int right = height(node.right);
        int max = Math.max(left, right);

        return max + 1;
    }

    public static int heightInNode(Node node) {
        if (node == null)
            return 0;

        int left = height(node.left);
        int right = height(node.right);
        int max = Math.max(left, right);

        return max + 1;
    }

    public static int maxVal(Node node) {
        if (node == null)
            return -1e9;

        int left = maxVal(node.left);
        int right = maxVal(node.right);

        int max = Math.max(left, right);
        return Math.max(node.data, max);

    }

    public static int minVal(Node node) {
        if (node == null)
            return 1e9;

        int left = minVal(node.left);
        int right = minVal(node.right);

        int max = Math.min(left, right);
        return Math.min(node.data, max);

    }

    public static int sum(Node node) {
        if (node == null)
            return 0;

        int leftSum = sum(node.left);
        int rightSum = sum(node.right);

        return leftSum + rightSum + node.data;
    }
    
    public static boolean find(Node node, int val){
        if(node == null)return false;

        if(node.data == val)return true;

        boolean left = find(node.left, val);
        boolean right =  find(node.right, val);

        return left || right;
    }

    public static void nodeToRootPath(Node node, int val, ArrayList<Node> ans){

        if(node == null)return;

        if(node.data == val){
            ans.add(node);
            return;
        }

        nodeToRootPath(node.left, val, ans);
        if(ans.size() > 0){
            ans.add(node);
            return;
        }
        nodeToRootPath(node.right, val, ans);
        if(ans.size() > 0){
            ans.add(node);
            return;
        }

        return;
    }

    public static void printNodeAtK(Node node, int k, ArrayList<Node> ans){
       if(node == null)return;
        if(k == 0){
            ans.add(node);
            return;
        }

        printNodeAtK(node.left, k-1, ans);
        printNodeAtK(node.right, k-1, ans);

        return;
    }
//phele to node to root path mangvao
// jab tak arraylist me maal hai

}