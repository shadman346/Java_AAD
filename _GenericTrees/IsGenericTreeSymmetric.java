package _GenericTrees;

public class IsGenericTreeSymmetric {
    public static void main(String[] args) {
        CreateGenericTree tree = new CreateGenericTree();


        if(isSymmetric(tree.root)){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }

    public static boolean isSymmetric(Node node){
        int size = node.children.size();

        for (int i = 0; i <= (size - 2) / 2; i++) { //(size-2)/2 handle case for both even and odd.
            Node childL = node.children.get(i);
            Node childR = node.children.get(size - 1 - i);
            if(!AreTreesMirorInShape.areMirror(childL,childR)){
                return false;
            }
        }
        if(size%2==1){
            return isSymmetric(node.children.get(size/2));
        }

        return true;

    }
}
