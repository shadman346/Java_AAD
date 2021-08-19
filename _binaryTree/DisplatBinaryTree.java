package _binaryTree;

public class DisplatBinaryTree {
    public static void main(String[] args) {
        Node root = ConstructorBinaryTree.rootBt();
        display(root);
    }

    static void display(Node root){
        if(root==null) return;
        System.out.println(root.data);
        display(root.left);
        display(root.right);
    }

}
