package lianbiao;

/**
 *
 *  1 -> 2 -> 4 -> 9
 *  2 -> 3 -> 5 -> 6 -> 8
 *
 *  合并2个有序链表
 */
public class Test05 {

    public static void main(String[] args) {
        Node head1 = buildNodeList1();
        printLink(head1);

        Node head2 = buildNodeList2();
        printLink(head2);

        Node head = merge(head1,head2);
        printLink(head);

    }

    private static Node merge(Node head1, Node head2) {
        if(head1 == null && head2 != null){
            return head2;
        }
        if(head1 != null && head2 == null){
            return head1;
        }

        Node p1 = head1;
        Node p2 = head2;
        Node head = null;
        Node tail = null;
        //新链表的头指针
        if(p1.data <= p2.data){
            head = new Node(p1.data);
            p1 = p1.next;
        }else {
            head = new Node(p2.data);
            p2 = p2.next;
        }
        tail = head;

        Node temp = null;
        while (p1 != null && p2 != null){
            if(p1.data <= p2.data){
                temp = new Node(p1.data);
                p1 = p1.next;
            }else {
                temp = new Node(p2.data);
                p2 = p2.next;
            }
            tail.next = temp;
            tail = temp;
        }

        if(p1 == null){
            tail.next = p2.next;
        }
        if(p2 == null){
            tail.next = p1.next;
        }

        return head;
    }

    private static void printLink(Node head) {
        Node temp = head;
        while (temp != null){
            System.out.print(temp+",");
            temp = temp.next;
        }
        System.out.println();
    }

    private static Node buildNodeList1() {
        Node head = new Node(1);

        Node n2 = new Node(2);
        Node n3 = new Node(4);
        Node n4 = new Node(9);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;

        return head;
    }

    private static Node buildNodeList2() {
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
