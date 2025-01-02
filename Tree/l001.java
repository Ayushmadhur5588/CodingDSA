import java.util.ArrayList;

public class l001{
    public static class Node{
        int data = 0;
        Node left = null;
        Node right = null;

        Node(int data){
            this.data = data;
        }
    }

    //Traversal 
    public static void preOrder(Node node, ArrayList<Integer> ans){
        if(node == null)return; // base case (left or right is null)

        ans.add(node.data);
        preOrder(node.left, ans);
        preOrder(node.right, ans);
    }

    public static void inOrder(Node node, ArrayList<Integer> ans){
        if(node == null)return;

        inOrder(node.left, ans);
        ans.add(node.data);
        inOrder(node.right, ans);
    }
    
    public static void postOrder(Node node, ArrayList<Integer> ans){
        if(node == null)return;
        
        postOrder(node.left, ans);
        postOrder(node.right, ans);
        ans.add(node.data);
    }
}