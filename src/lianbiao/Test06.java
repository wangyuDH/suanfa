package lianbiao;

/**
 * 2 -> 3 -> 5 -> 6 -> 8
 *  单链表的反转
 */
public class Test06 {

    public static void main(String[] args) {
        //非递归
        Node head1 = buildNodeList();
        printLink(head1);

        Node mergeHead1 = merge1(head1);
        printLink(mergeHead1);
        System.out.println("===============================================================================================================");

        //递归
        Node head2 = buildNodeList();
        printLink(head2);

        Node recursionHead1 = recursionMerge1(head2);
        printLink(recursionHead1);
        System.out.println("===============================================================================================================");

    }

    private static Node merge1(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        //哨兵
        Node guard = new Node(head);
        Node newHead = null;
        Node p = guard.next;
        while (p != null){
            Node q = p.next;
            p.next = newHead;
            newHead = p;
            p = q;
        }

        return newHead;
    }

    private static Node recursionMerge1(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        Node temp = head.next;
        Node newHead = recursionMerge1(head.next);
        temp.next = head;
        head.next = null;

        return newHead;
    }

    private static void printLink(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp + ",");
            temp = temp.next;
        }
        System.out.println();
    }

    private static Node buildNodeList() {
        Node head = new Node(2);

        Node n2 = new Node(3);
        Node n3 = new Node(5);
        Node n4 = new Node(6);
        Node n5 = new Node(8);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        return head;
    }

}
