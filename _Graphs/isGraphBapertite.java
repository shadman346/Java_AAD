package _Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;

class isGraphBipartite {
    //if it is possible to divide vertices into 2 mutually exclusive sets & exhaustive sets
    //such that all edges arr across set.

    //when is it Bipartite?
    // acyclic will always be bipartite
    // cyclic-evn will also be bipartite
    // cyclic-odd will not be bipartite i.e take cycle of 3 vertices(triangle) you can never satisfy conditions
    static class Edge{
        int src;
        int nbr;
        Edge(int src, int nbr){
            this.src = src;
            this.nbr= nbr;
        }
    }

    static class Pair{
        int src;
        int lvl;
        Pair(int src, int lvl){
            this.src=src;
            this.lvl=lvl;
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{2,4},{1,3},{3,5},{4,5}};
        int n = 6; //vertices
        int k = edges.length; //edges

        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i=0; i<n; i++){
            graph[i]= new ArrayList<>();
        }
        for (int e = 0; e<k; e++ ){
            int v1 = edges[e][0];
            int v2 = edges[e][1];

            graph[v1].add(new Edge(v1,v2));
            graph[v2].add(new Edge(v2,v1));
        }
        boolean[] isVisited = new boolean[n];
        boolean ans=false;
        for (int v=0; v<n; v++){
            if(!isVisited[v]) {
                ans = isNotBipartite(graph, v, isVisited);
                if (ans) break;
            }
        }
        if(ans){
            System.out.println("it is not Bipartite");
        }else{
            System.out.println("it is Bipartite");
            System.out.println(odd.toString());
            System.out.println(even.toString());
        }
    }
    static HashSet<Integer> odd = new HashSet<>();
    static HashSet<Integer> even = new HashSet<>();

    public static boolean isNotBipartite(ArrayList<Edge>[]graph, int src, boolean[]isVisited){
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src,0));
        while (!queue.isEmpty()){
            Pair v = queue.remove();
            boolean isEven = ((v.lvl % 2) == 0) ? true : false;
            if(isVisited[v.src]){
                if(isEven && odd.contains(v.src)){
                    return true;
                }
                if(!isEven && even.contains(v.src)){
                    return true;
                }
                continue;
            }
            isVisited[v.src]=true;
            if(isEven){
                even.add(v.src);
            }else {
                odd.add(v.src);
            }
            for(Edge e:graph[v.src]){
                if(!isVisited[e.nbr]){
                    queue.add(new Pair(e.nbr, v.lvl+1));
                }
            }
        }

        return false;
    }


}
