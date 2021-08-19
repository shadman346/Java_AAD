package _Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {
    static class Edge{
        int src;
        int nbr;
        int wt;
        Edge(int src, int nbr,int wt){
            this.src = src;
            this.nbr= nbr;
            this.wt=wt;
        }
    }

    static class Pair implements Comparable<Pair>{
        int src;
        int through;
        int wt;
        Pair(int src,int through,int wt){
            this.src=src;
            this.through=through;
            this.wt=wt;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1,10},{1,2,10},{0,3,20},{2,3,30},{3,4,2},{4,6,8},{5,6,3},{5,4,3}};
        int n = 7; //vertices
        int k = edges.length; //edges

        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i=0; i<n; i++){
            graph[i]= new ArrayList<>();
        }
        for (int e = 0; e<k; e++ ){
            int v1 = edges[e][0];
            int v2 = edges[e][1];
            int wt = edges[e][2];

            graph[v1].add(new Edge(v1,v2,wt));
            graph[v2].add(new Edge(v2,v1,wt));
        }

            primsAlgo(graph,0);
    }

    public static void primsAlgo(ArrayList<Edge>[]graph, int src){
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(src,-1,0));
        boolean[] isVisited = new boolean[graph.length];
        while (!queue.isEmpty()){
            Pair rem = queue.remove();
            if(isVisited[rem.src]) continue;
            if(rem.through!=-1) {
                System.out.println(rem.src+"-"+rem.through+"@"+ rem.wt);
            }
            isVisited[rem.src]=true;
            for(Edge e:graph[rem.src]){
                if(!isVisited[e.nbr]){
                    queue.add(new Pair(e.nbr,e.src,e.wt));
                }
            }
        }
    }
}
