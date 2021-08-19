package _GenericTrees;

public class RemoveLeaves {
    public static void main(String[] args) {
        CreateGenericTree cr = new CreateGenericTree();


        Node root = cr.root;
        LineWiseTraversals.levelOrderLineWise3(root);
        removeLeaves(root);
        System.out.println();
        System.out.println();
        LineWiseTraversals.levelOrderLineWise3(root);

    }

    public static void removeLeaves(Node node){
        for(int i = node.children.size()-1; i>=0; i--){
            Node child = node.children.get(i);
            if(child.children.size() == 0){
                node.children.remove(child);
            }
        }

        for (Node child:node.children){
            removeLeaves(child);
        }
    }
}
