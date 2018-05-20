import java.util.Arrays;

public class BTree{
    private BTreeNode root;
    private int order;
    public BTree(int r,int order) {
        root = new BTreeNode(r);
        this.order = order;
        if(order<2){throw new IllegalArgumentException("order must be greater than or equal to 2");}
    }
    public void insert(int t){

    }
    private class BTreeNode implements Comparable<BTreeNode>{
        private int[] left,right;
        private int element;
        public BTreeNode(int element) {
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
        public int compareTo(BTreeNode o) {
            return element-o.element;
        }
    }
}
