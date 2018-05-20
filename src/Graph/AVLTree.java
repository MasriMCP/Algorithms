package Graph;

public class AVLTree<T extends  Comparable<T>> {
    private Node<T> root;

    public AVLTree(T t) {
        this.root = new Node<T>(t);
    }
    public void insert(T t){
        root = insert(root,t);
    }
    public void printInorder(){
        inorder(root);
    }

    private void inorder(Node<T> node) {
        if(node==null) return;
        inorder(node.left);
        System.out.println(node);
        inorder(node.right);
    }

    private Node<T> insert(Node<T> node,T t){
        if(node == null) return new Node<T>(t);

        if(node.element.compareTo(t)>0){
            node.left = insert(node.left,t);
        }
        else if(node.element.compareTo(t)<0){
            node.right = insert(node.right,t);
        }
        else{
            return node;
        }
        int balance = node.getBalance();

        if(balance > 1 && node.left.element.compareTo(t)>0){
            node.right = rightRotate(node);
            return leftRotate(node);
        }
        if(balance < -1 && node.right.element.compareTo(t)<0){
            node.left = leftRotate(node);
            return rightRotate(node);
        }
        if(balance > 1 && node.left.element.compareTo(t)<0){

            return rightRotate(node);
        }
        if(balance < -1 && node.right.element.compareTo(t)>0){

            return leftRotate(node);
        }

        return node;
    }

    private Node<T> leftRotate(Node<T> node){
        Node<T> y = node.right;
        Node<T> t2 = y.left;
        y.left = node;
        node.right = t2;
        return y;
    }
    private Node<T> rightRotate(Node<T> node){
        Node<T> x = node.left;
        Node<T> T2 = x.right;
        x.right = node;
        node.left = T2;
        return x;
    }
    private class Node<T>{
        Node<T> parent,left,right;
        T element;
        Node(T element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return
                    "element=" + element +
                    " height="+ getHeight();
        }
        int getHeight(){
            return getHeight(this);
        }
        int getBalance(){
            if(left == null && right == null){
                return 0;
            }
            if(left==null){
                return -right.getHeight();
            }
            if(right==null){
                return left.getHeight();
            }
            return left.getHeight()-right.getHeight();
        }
        private int getHeight(Node<T> t){
            if(t.left == null && t.right == null){
                return 0;
            }
            if(t.left==null){
                return getHeight(t.right)+1;
            }
            if(t.right==null){
                return getHeight(t.left)+1;
            }
            int r = getHeight(t.right)+1;
            int l=getHeight(t.left)+1;
            return r>l?r:l;
        }
    }
}
