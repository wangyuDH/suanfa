package lianbiao;

/**
 *   1 2 3 4 3 2 1
 *
 *   判断回环字符串
 */
public class Test02 {

    public static void main(String[] args) {
        Node head = buildNodeList();
        printLink(head);

        boolean loop = loop(head);
        System.out.println("loop: "+ loop);
        System.out.println("=====================================");

    }

    private static boolean loop(Node head) {
        if(head == null || head.next == null){
            return true;
        }
        Node guard = new Node(head);
        Node slow = guard;
        Node fast = guard;
        Node reverseHead = null;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            Node temp = slow.next;

            slow.next = reverseHead;
            reverseHead = slow;
            slow = temp;
        }
        //奇数
        if (fast == null){
            slow = slow.next;
        }

        while (slow != null){
            if(slow.data != reverseHead.data){
                return false;
            }
            slow = slow.next;
            reverseHead = reverseHead.next;
        }

        return true;
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
        Node n5 = new Node(3);
        Node n6 = new Node(2);

        Node n7 = new Node(1);
        //Node n7 = new Node(7);

        head.next = n2;

        n2.next = n3;

        n3.next = n4;

        n4.next = n5;

        n5.next = n6;

        n6.next = n7;

        return head;
    }
}
