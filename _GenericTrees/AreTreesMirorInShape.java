package _GenericTrees;

public class AreTreesMirorInShape {
    public static void main(String[] args) {
        CreateGenericTree tree1 = new CreateGenericTree();
        CreateGenericTree tree2 = new CreateGenericTree();

        if(areMirror(tree1.root, tree2.root)){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }

    public static boolean areMirror(Node node1 , Node node2){
        int s1 = node1.children.size()-1;
        int s2 = node2.children.size()-1;
        if(s1!=s2){
            return false;
        }
        for(int i=0; i<=s1; i++){
            Node c1 = node1.children.get(i);
            Node c2 = node2.children.get(s1-i);
            if(!areMirror(c1,c2)) return false;
        }
        return true;
    }
}




