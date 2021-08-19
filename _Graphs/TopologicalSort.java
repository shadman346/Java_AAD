package _Graphs;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Stack;

public class TopologicalSort {
    // A permutation of vertices for an acyclic graph is called topological sort
    //for all edges uv , u appears before v in a list of vertices of graph.
    // it is useful to know in which order should we compile things or files so that other dependent files  wont have any conflict
    static class Edge{
        int src;
        int nbr;
        Edge(int src, int nbr){
            this.src = src;
            this.nbr= nbr;
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,3},{1,2},{2,3},{4,3},{4,5},{4,6},{5,6}};
        int n = 7; //vertices
        int k = edges.length; //edges

        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i=0; i<n; i++){
            graph[i]= new ArrayList<>();
        }
        for (int e = 0; e<k; e++ ){
            int v1 = edges[e][0];
            int v2 = edges[e][1];
            graph[v1].add(new Edge(v1,v2));
        }

        HashSet<Integer> isVisited = new HashSet<>();
        Stack<Integer> st = new Stack<>();
        for(int v=0 ; v<n; v++) {
            if(!isVisited.contains(v)) {
                topologicalSort(graph,v, st, isVisited);
            }
        }
        Collections.reverse(st);
        System.out.println(st);
    }
    public static void topologicalSort(ArrayList<Edge>[]graph,int src, Stack<Integer>st,HashSet<Integer>isViisited){
        isViisited.add(src);
        for(Edge e:graph[src]){
            if(!isViisited.contains(e.nbr)){
                topologicalSort(graph, e.nbr, st, isViisited);
            }
        }

        st.add(src);
    }

}
