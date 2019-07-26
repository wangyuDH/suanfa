package lianbiao;

/**
 *
 * 1 -> 2 -> 3 -> 4 -> 5 ->6
 *
 *  求链表的中间结点
 */
public class Test03 {

    public static void main(String[] args) {
        Node head = buildNodeList();
        printLink(head);

        Node node = calcMidNode(head);
        System.out.println("midNode: "+ node);


    }

    private static Node calcMidNode(Node head) {
        if(head == null || head.next == null){
            return head;
        }

        Node guard = new Node(head);
        Node slow = guard;
        Node fast = guard;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
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
        //Node n5 = new Node(5);
        //Node n6 = new Node(6);
        //Node n7 = new Node(7);
        //Node n8 = new Node(8);

        head.next = n2;
        n2.next = n3;
        //n3.next = n4;

        return head;
    }
}
