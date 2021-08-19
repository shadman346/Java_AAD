package _GenericTrees;

public class FIndElementInTree {
    public static void main(String[] args) {
        CreateGenericTree start = new CreateGenericTree();

        int find = 110;
        if(find(start.root, find)){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }

    public static boolean find(Node node, int x){
        if(node.data==x){
            return true;
        }
        for(Node child: node.children){
            if(find(child,x)){
                return true;
            }
        }

        return false;
    }
}
