package lianbiao;

import com.sun.corba.se.impl.encoding.CodeSetConversion;

/**
 *                 7
 *            ↙        ↖
 * 1 -> 2 -> 3 -> 4 -> 5 ->6
 *
 *  1 判断是否有环
 *  2 有环的话求相遇点
 *  3 有环的话求环的入口
 */
public class Test {

    public static void main(String[] args) {
        Node head = buildNodeList();

        boolean loop1 = loop1(head);
        System.out.println("loop12: "+ loop1);
        System.out.println("=====================================");

        boolean loop2 = loop2(head);
        System.out.println("loop13: "+ loop2);
        System.out.println("=====================================");

        boolean loop3 = loop3(head);
        System.out.println("loop14: "+ loop3);
        System.out.println("=====================================");

        boolean loop4 = loop4(head);
        System.out.println("loop15: "+ loop4);
        System.out.println("=====================================");
    }

    private static boolean loop1(Node head) {
        if(head == null || head.next == null){
            return false;
        }

        Node guard = new Node(head);
        Node slow = guard;
        Node fast = guard;
        int c1 = 0;
        while (fast != null){
            slow = slow.next;
            fast = fast.next.next;
            c1++;
            if(slow == fast){
                System.out.println("相遇点node: "+ slow +",step12: "+c1);
                Node temp = guard;

                while (true){
                    fast = fast.next;
                    temp = temp.next;
                    if(fast == temp){
                        System.out.println("环的起点node: "+ fast);
                        break;
                    }
                }
                return true;
            }
        }

        return false;
    }

    private static boolean loop2(Node head) {
        if(head == null || head.next == null || head.next.next == null){
            return false;
        }

        Node guard = new Node(head);
        Node slow = guard;
        Node fast = guard;
        int c2 = 0;
        while (fast != null){
            slow = slow.next;
            fast = fast.next.next.next;
            c2++;
            if(slow == fast){
                System.out.println("current node: "+ slow + ",step13: "+c2);
                return true;
            }
        }

        return false;
    }

    private static boolean loop3(Node head) {
        if(head == null || head.next == null || head.next.next == null){
            return false;
        }

        Node guard = new Node(head);
        Node slow = guard;
        Node fast = guard;
        int c2 = 0;
        while (fast != null){
            slow = slow.next;
            fast = fast.next.next.next.next;
            c2++;
            if(slow == fast){
                System.out.println("current node: "+ slow + ",step14: "+c2);
                return true;
            }
        }

        return false;
    }

    private static boolean loop4(Node head) {
        if(head == null || head.next == null || head.next.next == null){
            return false;
        }

        Node guard = new Node(head);
        Node slow = guard;
        Node fast = guard;
        int c2 = 0;
        while (fast != null){
            slow = slow.next;
            fast = fast.next.next.next.next.next;
            c2++;
            if(slow == fast){
                System.out.println("current node: "+ slow + ",step15: "+c2);
                return true;
            }
        }

        return false;
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

        n7.next = head;

        //n8.next = head;

        return head;
    }
}
