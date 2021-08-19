package _binaryTree;

public class TransformToLeftClone {
    public static Node main(String[] args) {
        Node root = ConstructorBinaryTree.rootBt();
        transform(root);
        return root;
    }

    private static void transform(Node root) {
        if(root==null) return;

        transform(root.left);
        transform(root.right);
        Node cloneNode = new Node(root.data);
        cloneNode.left=root.left;
        root.left=cloneNode;
    }
}
