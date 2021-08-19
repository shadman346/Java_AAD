package _GenericTrees;

import java.util.*;

public class MirrorAGenericTree {
    public static void main(String[] args) {
        CreateGenericTree cr = new CreateGenericTree();
        Node root = cr.root;

//        mirrorLineWise(root);
        mirrorRecur(root);

        LineWiseTraversals.levelOrderLineWise3(root);

    }
    public static void mirrorLineWise(Node node){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()){
            node =queue.remove();

            Collections.reverse(node.children);
            for(Node child:node.children){
                queue.add(child);
            }
        }

    }

    public static void mirrorRecur(Node node){
        for(Node child: node.children){
            mirrorRecur(child);
        }
        Collections.reverse(node.children);
    }

    // dont know why this does not work
    public static void reverse(ArrayList<Node> arr) {
        int size = arr.size();
        for(int i =0 , j=size-1 ; i<size/2-1; i++,j--){
            Node temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j,temp);
        }
    }
}
