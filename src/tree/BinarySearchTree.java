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
        Node root = new Node(10);

        //新增二叉查找数树
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
        //中序遍历
        midPrint(root);

        //删除
        remove(root,11);
        //中序遍历
        midPrint(root);

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

        // 要删除的节点有两个子节点
        if(p.left != null && p.right != null){

        }
        // 删除节点是仅有一个子节点
        Node child = null;
        if(p.left == p){
            child = p.left;
        }else{
            child = p.right;
        }


        // 删除的节点没有子节点
        if(pp.left == p){
            pp.left = null;
        }else{
            pp.right = null;
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
