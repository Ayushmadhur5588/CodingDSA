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
    public int kthFromLast(int k) {
        Node slow = head;
        Node fast = head;

        while (k-- > 0) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;
    }

    public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
        Node c1 = l1.head;
        Node c2 = l2.head;

        LinkedList ans = new LinkedList();
        while (c1 != null && c2 != null) {
            if (c1.data < c2.data) {
                ans.addLast(c1.data);
                c1 = c1.next;
            } else {
                ans.addLast(c2.data);
                c2 = c2.next;
            }
        }

        while (c1 != null) {
            ans.addLast(c1.data);
            c1 = c1.next;
        }

        while (c2 != null) {
            ans.addLast(c2.data);
            c2 = c2.next;
        }

        return ans;
    }

    public static Node midNode(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
    public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
        one.reversePI();
        two.reversePI();

        LinkedList ans = new LinkedList();

        Node c1 = one.head;
        Node c2 = two.head;
        int carry = 0;
        while (c1 != null || c2 != null || carry != 0) {
            int sum = (c1 != null ? c1.data : 0) + (c2 != null ? c2.data : 0) + carry;

            carry = sum / 10;
            sum = sum % 10;

            ans.addFirst(sum);

            if (c1 != null)
                c1 = c1.next;
            if (c2 != null)
                c2 = c2.next;

        }

        one.reversePI();
        two.reversePI();

        return ans;
    }

    public static LinkedList addTwoLists(LinkedList one, LinkedList two) {

        LinkedList ans = new LinkedList();

        int carry = 0;

        if (one.size() > two.size())
            carry = addTwoLists(one.head, two.head, one.size(), two.size(), ans);
        else
            carry = addTwoLists(two.head, one.head, two.size(), one.size(), ans);

        if (carry == 1) {
            ans.addFirst(1);
        }

        return ans;
    }

}