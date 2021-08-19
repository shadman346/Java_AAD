package _GenericTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class NodeToRootPath {
    public static void main(String[] args) {
        CreateGenericTree tree = new CreateGenericTree();
        int[] arr = {12,213,1231,31,1,12};
        int fromNode = 120;
        ArrayList<Integer> ans = path(tree.root, fromNode);
        System.out.println(ans);
//        Arrays.asList(arr);
//        System.out.println(arr.);
    }

    public static ArrayList<Integer> path(Node node, int x){
        if(node.data==x){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(x);
            return list;
        }

        for(Node child: node.children){
            ArrayList<Integer> list = path(child,x);
            if(list.size()>0){
                list.add(node.data);
                return list;
            }
        }

        return new ArrayList<>();
    }
}
