package _GenericTrees;

import java.util.ArrayList;

public class Node {
        int data;
        ArrayList<_GenericTrees.Node> children = new ArrayList<>();

        Node(){

        }
        Node(int x){
                this.data=x;
        }
}
