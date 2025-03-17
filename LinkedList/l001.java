public class l001 {
    public class Node {
        int data;
        Node next;
    }

    Node head = null;
    Node tail = null;

    public int mid() {
        Node slow = head;
        Node fast = head;
        // while(fast != null && fast.next != null) // 2nd mid of even length linkedlist
        while (fast.next != null && fast.next.next != null) { // 1mid of even length linkedlist
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }

    public void reversePI() {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node forw = curr.next; // backup

            curr.next = prev; // link

            prev = curr; // move
            curr = forw;
        }

        tail = head;
        head = prev;
    }
    public Node getNodeAt(int idx) {
        Node curr = head;
        while (idx-- > 0) {
            curr = curr.next;
        }

        return curr;
    }

    public int length() {
        int len = 0;
        Node curr = head;
        while (curr != null) {
            curr = curr.next;
            len++;
        }

        return len;
    }

    public void reverseDI() {
        int i = 0;
        int j = length() - 1;

        while (i < j) {
            Node in = getNodeAt(i);
            Node jn = getNodeAt(j);

            int temp = in.data;
            in.data = jn.data;
            jn.data = temp;

            i++;
            j--;
        }
    }
    private void displayReverseHelper(Node node) {
        if (node == null)
            return;

        displayReverseHelper(node.next);
        System.out.print(node.data + " ");
    }

    private void reversePRHelper(Node node) {
        if (node.next == null) {
            Node temp = head;
            head = tail;
            tail = temp;

            return;
        }

        reversePRHelper(node.next);

        Node forw = node.next;
        forw.next = node;
    }

    public void reversePR() {
        reversePRHelper(head);
        tail.next = null;
    }


}