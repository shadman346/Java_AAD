package _binaryTree;

public class TransformBackFromLeftClone {
    public static void main(String[] args) {
        Node root = TransformToLeftClone.main(null);
        transformBack(root);
        DisplatBinaryTree.display(root);
    }

    private static void transformBack(Node root) {
        if(root==null) return;
        root.left = root.left.left;
        transformBack(root.left);
        transformBack(root.right);

    }
}
