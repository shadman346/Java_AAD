package _GenericTrees;

import java.util.ArrayList;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        CreateGenericTree start = new CreateGenericTree();

        lca(start.root,120,110);
    }

    public static void lca(Node node, int x,int y){
        ArrayList<Integer> xList = NodeToRootPath.path(node,x); //root node at last of list
        ArrayList<Integer> yList = NodeToRootPath.path(node,y);
        int ans=0;
        int size = Math.min(xList.size(), yList.size());
        for(int i=size-1; i>=0;i--){
            x=xList.get(i);
            y=yList.get(i);
            if(x==y){
                ans=x;
            }else break;
        }

        System.out.println(ans);
    }
}
