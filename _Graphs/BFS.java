package _Graphs;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class BFS {
    static class Edge{
        int src;
        int nbr;
        Edge(int src, int nbr){
            this.src=src;
            this.nbr=nbr;
        }
    }
    static class Pair{
        int src;
        String psf;
        Pair(int src, String psf){
            this.src = src;
            this.psf = psf;
        }
    }
    public static void main(String[] args) throws Exception {

        int[][] edges = {{0,1},{1,2},{0,3},{2,3},{3,4},{4,6},{4,5},{5,6}};
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

        printDFS(graph,2);
    }
    public static void printDFS(ArrayList<Edge>[]graph,int src){
        boolean[] isVisited = new boolean[graph.length];
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, src + "")); // start point
        queue.add(new Pair(-1,""));
        while(queue.size()>1){
            Pair v = queue.remove();
            if(v.src==-1 ){
                queue.add(new Pair(-1,""));
                System.out.println();
                continue;
            }
            if(isVisited[v.src]) continue;

            isVisited[v.src]=true;

            System.out.print(v.psf + "   ");
            for(Edge edge:graph[v.src]){
                if(!isVisited[edge.nbr]) {
                    queue.add(new Pair(edge.nbr,v.psf+edge.nbr));
                }
            }

        }
    }
}
