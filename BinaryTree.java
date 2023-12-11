class Node {
    char data;
    Node left, right;

    public Node(char item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    private void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data);
            inorderTraversal(node.right);
        }
    }

    public void doInorderTraversal() {
        inorderTraversal(root);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node('-');
        tree.root.left = new Node('+');
        tree.root.right = new Node('E');
        tree.root.left.left = new Node('A');
        tree.root.left.right = new Node('*');
        tree.root.left.right.left = new Node('B');
        tree.root.left.right.right = new Node('-');
        tree.root.left.right.right.left = new Node('C');
        tree.root.left.right.right.right = new Node('D');

        System.out.print("Inorder Traversal Result: ");
        tree.doInorderTraversal();
    }
}
