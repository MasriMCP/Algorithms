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
        root.insert(t);
    }
    private class BTreeNode{
        Node[] list;
        int size = 0;
        boolean leaf = true;
        public BTreeNode(int order) {
            list = new Node[order];
        }
        void insert(int t){
            if(!leaf){
                for(int i = 0;i<order;i++){
                    if(list[i].element>t){
                        list[i].left.insert(t);
                        break;
                    }
                }

            }
           else{
                if(size<order) {
                    list[size] = new Node(t);
                    Arrays.sort(list);
                    size++;
                }
                else{

                }
            }
        }
    }
    private class Node implements Comparable<Node>{
        private BTreeNode left,right;
        private int element;
        public Node(int element) {
            this.element = element;
        }
        public BTreeNode getLeft() {
            return left;//DO NOT USE THIS METHOD TO INSERT/DELETE FROM TREE
        }

        public BTreeNode getRight() {
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
