package tree;

/**
 *                0
 *              1   2
 *           11 12 21 22
 *         111
 * 二叉树的 前中后序 遍历
 * 前序: print() = print(c)+print(c.left)+print(c.right)
 * 中序: print() = print(c.left)+print(c)+print(c.right)
 * 后序: print() = print(c.left)+print(c.right)+print(c)
 */
public class BinaryTree {
    public static void main(String[] args) {
        Node root = buildTree();

        //前序
        prePrint(root);

        //计算树的最大高度
        int deep = calcDeep(root);
        System.out.println("\ndeep: " + deep);
    }

    private static int calcDeep(Node node) {
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null){
            return 1;
        }

        return Math.max(calcDeep(node.left),calcDeep(node.right)) + 1;
    }

    private static void prePrint(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data+ " ");
        prePrint(root.left);
        prePrint(root.right);
    }

    private static Node buildTree() {
        Node root = new Node(0);

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        root.left = n1;
        root.right = n2;

        Node n11 = new Node(11);
        Node n12 = new Node(12);
        n1.left = n11;
        n1.right = n12;

        Node n21 = new Node(21);
        Node n22 = new Node(22);
        n2.left = n21;
        n2.right = n22;

        Node n111 = new Node(111);
        n11.left = n111;

        return root;
    }
}

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}
