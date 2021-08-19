package _GenericTrees;

import java.util.ArrayList;

public class DistanceBtwNodes {
    public static void main(String[] args) {
        CreateGenericTree start = new CreateGenericTree();
        Dbn(start.root,70,110);

    }

    public static void Dbn(Node node , int x , int y){
        ArrayList<Integer> L1 = NodeToRootPath.path(node,x);
        ArrayList<Integer> L2 = NodeToRootPath.path(node,y);

        int i = L1.size()-1;
        int j = L2.size()-1;
        while(i>=0 && j>=0 && L1.get(i)==L2.get(j)){
            i--;
            j--;
        }
        i++;
        j++;
        System.out.println(i+j);
    }
}
