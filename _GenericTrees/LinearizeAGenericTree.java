package _GenericTrees;

public class LinearizeAGenericTree{
    public static void main(String[] args) {
        CreateGenericTree start = new CreateGenericTree();
        LineWiseTraversals.display(start.root);
        linearizeTree2(start.root);
        System.out.println("After Linearize");
        LineWiseTraversals.display(start.root);

    }

    // n^2 operation
    public static void linearizeTree1(Node node){
        for(Node child:node.children){
            linearizeTree1(child);
        }
        while(node.children.size()>1){
            Node lastChild = node.children.remove(node.children.size()-1);
            Node secondLastChild = node.children.get(node.children.size()-1);
            Node secondLastChildTail = getTail(secondLastChild);
            secondLastChildTail.children.add(lastChild);
        }
    }

    private static Node getTail(Node node){
        while(node.children.size()==1){
            node=node.children.get(0);
        }
        return node;
    }

    // we are returning tail node with linearize and it reduces complexity
    // as it reduce operation for finding tail separately using getTail();
    public static Node linearizeTree2(Node node){
        if(node.children.size()==0){
            return node;
        }
        // it linearize sub part of tree as well as return tail node
        Node lastChildTail = linearizeTree2(node.children.get(node.children.size()-1));

        while(node.children.size()>1){
            Node lastChild = node.children.remove(node.children.size()-1);
            Node secondLastChild = node.children.get(node.children.size()-1);
            Node secondLastChildTail = linearizeTree2(secondLastChild); // return tail node;
            secondLastChildTail.children.add(lastChild);
        }

        return lastChildTail;
    }
}
