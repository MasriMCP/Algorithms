import java.util.Arrays;

public class BTree{
    private BTreeNode root;
    private int order;
    public BTree(int r,int order) {
        root = new BTreeNode(order);
        this.order = order;
        if(order<2){throw new IllegalArgumentException("order must be greater than or equal to 2");}
    }
    public void insert(int t){

    }
    private class BTreeNode{
        Node[] list;
        int size = 0;
        boolean leaf = true;
        public BTreeNode(int order) {
            list = new Node[order];
        }
        void insert(int t){
            list[size] = new Node(t);
            Arrays.sort(list);
            size++;
        }
    }
    private class Node implements Comparable<Node>{
        private int[] left,right;
        private int element;
        public Node(int element) {
            this.element = element;
        }
        public int[] getLeft() {
            return left;//DO NOT USE THIS METHOD TO INSERT/DELETE FROM TREE
        }

        public int[] getRight() {
            return right;//DO NOT USE THIS METHOD TO INSERT/DELETE FROM TREE
        }

        public int getElement() {
            return element;
        }

        @Override
        public int compareTo(Node o) {
            return element-o.element;
        }
    }
}
