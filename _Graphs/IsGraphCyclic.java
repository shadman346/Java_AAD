package _Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class IsGraphCyclic {
    static class Edge{
        int src;
        int nbr;
        Edge(int src, int nbr){
            this.src = src;
            this.nbr= nbr;
        }
    }
    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{2,3},{3,4},{4,6},{5,6}};
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
            graph[v2].add(new Edge(v2,v1));
        }

        boolean[] isVisted = new boolean[n];
        boolean ans =false;
        for(int v=0; v<n; v++){
            if (!isVisted[v]) {
                ans = isCyclicBFS(graph, v, isVisted);
                if (ans) break;
            }
        }
        if(ans){
            System.out.println("it is cyclic");
        }else{
            System.out.println("Not cyclic");
        }
    }

    public static boolean isCyclicBFS(ArrayList<Edge>[] graph, int src, boolean[]isVisited){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(src);

        while (!queue.isEmpty()){
            int v = queue.remove();
            if(isVisited[v]) return true;
            isVisited[v]=true;
            for (Edge e:graph[v]){
                if(!isVisited[e.nbr]) {
                    queue.add(e.nbr);
                }
            }
        }
        return false;
    }

}
