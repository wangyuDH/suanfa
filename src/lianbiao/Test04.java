package lianbiao;

/**
 *
 * 1 -> 2 -> 3 -> 4 -> 5 ->6 ->7 ->8
 *
 *  删除链表倒数第n个结点(n有效)
 */
public class Test04 {

    public static final int N = 1;

    public static void main(String[] args) {
        Node head = buildNodeList();
        printLink(head);

        head = delNNode(N,head);
        printLink(head);

    }

    private static Node delNNode(int n,Node head) {
        if(head == null){
            return null;
        }
        Node guard = new Node(head);
        Node slow = guard;
        Node fast = guard;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        //头指针
        if (fast.next == null){
            head = head.next;
            return head;
        }

        //多走一步
        fast = fast.next;

        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next=slow.next.next;
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

    private static Node buildNodeList() {
        Node head = new Node(1);

        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        return head;
    }
}
