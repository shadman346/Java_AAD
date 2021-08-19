package _GenericTrees;

public class AreTreesSimilarInShape {
    public static void main(String[] args) {
        CreateGenericTree start1 = new CreateGenericTree();
        CreateGenericTree start2 = new CreateGenericTree();

        if(areSimilar(start1.root,start2.root)){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }

    public static boolean areSimilar(Node node1, Node node2){
        int sz1 = node1.children.size();
        int sz2 = node2.children.size();
        if(sz1==sz2){
            for(int i=0; i<sz1; i++){
                Node child1= node1.children.get(i);
                Node child2= node2.children.get(i);
                if(!areSimilar(child1,child2)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
