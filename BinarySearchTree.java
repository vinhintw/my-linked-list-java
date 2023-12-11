class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int item) {
        data = item;
        left = right = null;
    }
}

public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private TreeNode insertRec(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }

        if (key < root.data) {
            root.left = insertRec(root.left, key);
        } else if (key > root.data) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    public void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();

    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    for (int number : numbers) {
        tree.insert(number);
    }

    // Tính giá trị trung bình của dãy số
    double average = Arrays.stream(numbers).average().orElse(Double.NaN);

    System.out.println("Average of the array: " + average);
}

}
