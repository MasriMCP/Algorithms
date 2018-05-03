package Graph;


import java.util.Iterator;

public class Tree implements Iterable<Integer>{
    private TreeNode root;
    public final static int PREORDER = 0, INORDER = 1, POSTORDER = 2;

    public void insert(int a) {
        root = insertNew(a, root);
    }

    public void insert(int... a) {
        for (int i : a)
            insert(i);
    }

    public void delete(int a) {
        deleteElement(a, root);
    }

    public void visit(int t) {
        System.out.print(t + " ");
    }

    public void traverse(int i) {
        if (i == PREORDER) {
            preorder(root);
        } else if (i == INORDER) {
            inorder(root);
        } else if (i == POSTORDER) {
            postorder(root);
        } else {
            throw new IllegalArgumentException("invalid input: " + i);
        }
    }

    private void preorder(TreeNode t) {
        if (t != null) {
            visit(t.info);
            preorder(t.left);
            preorder(t.right);
        }
    }

    private void inorder(TreeNode t) {
        if (t != null) {
            inorder(t.left);
            visit(t.info);
            inorder(t.right);
        }
    }

    private void postorder(TreeNode t) {
        if (t != null) {
            postorder(t.left);
            postorder(t.right);
            visit(t.info);
        }
    }

    private TreeNode insertNew(int a, TreeNode t) {
        if (t == null) {
            t = new TreeNode(a, null, null);
            return t;
        } else if (a > t.info) {
            t.right = insertNew(a, t.right);
            return t;
        } else if (a < t.info) {
            t.left = insertNew(a, t.left);
            return t;
        } else {
            return null;
        }
    }

    private TreeNode deleteElement(int a, TreeNode t) {
        TreeNode p, q, s;
        // search
        if (t == null) {
            return t;
        } else if (a < t.info) {
            t.left = deleteElement(a, t.left);
            return t;
        } else if (a > t.info) {
            t.right = deleteElement(a, t.right);
            return t;
        } else {
            q = t;
            s = t;
        }
        // handle deletion
        if (q.right == null)
            t = q.left;
        else if (q.left == null)
            t = q.right;
        else {
            p = q.right;
            while (p.left != null) {
                // look for minimum in right subtree
                s = p;
                p = p.left;
            }
            t = p;
            t.left = q.left;
            s.left = p.right;
            if (q.right == p) {
                t.right = p.right;
            } else {
                t.right = q.right;
            }
        }
        return t;

    }


    private class TreeNode {
        protected int info;
        protected TreeNode left, right;

        public TreeNode() {

        }

        public TreeNode(int info, TreeNode left, TreeNode right) {
            this.info = info;
            this.left = left;
            this.right = right;
        }

    }
    @Override
    public Iterator<Integer> iterator() {
        return new TreeInorderIterator();
    }
    private class TreeInorderIterator implements Iterator<Integer>{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Integer next() {
            return null;
        }
    }
}
