package tree;

/**               33
 *           10       22
 *        6   9    15
 *
 */
public class HeadTest {
    public static void main(String[] args) {
        Heap heap = new Heap(6);
        heap.insert(6);
        heap.insert(33);
        heap.insert(15);
        heap.insert(10);
        heap.insert(9);
        heap.insert(22);
        System.out.println(heap);

        /*heap.removeMax();
        System.out.println(heap);*/

        heap.sort();
        System.out.println(heap);
    }
}
