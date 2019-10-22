package tree;

/**
 *               10
 *           8      14
 *        3  9    13   16
 *              11   15 17
 *                        99
 *        二叉查找数
 */
public class BinarySearchTree {

    public static void main(String[] args) {
        //构建二叉查找数树
        Node root = new Node(10);
        buildTree(root,new Node(8));
        buildTree(root,new Node(14));
        buildTree(root,new Node(13));
        buildTree(root,new Node(16));
        buildTree(root,new Node(11));
        buildTree(root,new Node(3));
        buildTree(root,new Node(9));
        buildTree(root,new Node(15));
        buildTree(root,new Node(17));

        //中序遍历
        midPrint(root);
        System.out.println();

        //删除
        remove(root,3);
        midPrint(root);
        System.out.println();

        //删除
        remove(root,13);
        midPrint(root);
        System.out.println();

    }

    private static void remove(Node root, int data) {
        Node p = root;
        Node pp = null;
        while (p != null && p.data != data) {
            pp = p;
            if(data < p.data){
                p = p.left;
            }else {
                p = p.right;
            }
        }
        //没有找到要删除的节点
        if(p == null){
            return;
        }

        // 1 要删除的节点有两个子节点
        if(p.left != null && p.right != null){
            Node right = p.right;

            Node min = right;
            Node rightMinLeftP = p;

            while (right.left != null){
                min = right.left;
                rightMinLeftP = right;

                right = right.left;
            }

            

        }

        // 2 删除的节点没有子节点或者仅有一个子节点
        Node child;
        if(p.left != null){
            child = p.left;
        }else if(p.right != null){
            child = p.right;
        }else {
            child = null;
        }

        if(pp == null){
            root = child;//删除根节点
        } else if(pp.left == p){
            pp.left = child;
        }else {
            pp.right = child;
        }

    }

    private static void midPrint(Node node) {
        if(node == null){
            return;
        }

        midPrint(node.left);
        System.out.print(node.data + " ");
        midPrint(node.right);
    }

    private static void buildTree(Node root,Node node) {
        Node p = root;
        while (p != null){
            if(node.data < p.data){
                if(p.left == null){
                    p.left = node;
                    return;
                }
                p = p.left;
            }else {
                if(p.right == null){
                    p.right = node;
                    return;
                }
                p = p.right;
            }
        }
    }
}
