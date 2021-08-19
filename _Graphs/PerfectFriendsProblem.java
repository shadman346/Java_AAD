package _Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PerfectFriendsProblem {
    static class Edge{
        int src;
        int nbr;

        Edge(int src, int nbr){
            this.src = src;
            this.nbr = nbr;

        }
    }

    // 3 club pairs
    //7
    //5
    //0 1
    //2 3
    //4 5
    //5 6
    //4 6
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //vertices
        int k = Integer.parseInt(br.readLine()); //edges


        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i=0; i<n; i++){
            graph[i]= new ArrayList<>();
        }

        for (int e = 0; e<k; e++ ){
            String line = br.readLine();
            String[] parts = line.split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);

            graph[v1].add(new Edge(v1,v2));
            graph[v2].add(new Edge(v2,v1));
        }

        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        boolean[] isVisited = new boolean[n];
        for(int v=0; v<n; v++){
            if(!isVisited[v]){
                ArrayList<Integer> comp = new ArrayList<>();
                giveComponent(graph, v,comp,isVisited );
                comps.add(comp);
            }
        }

        // total no of ways in which we can make pair such that no 2 child belong to same club
        int ways=0;
        for(int i=0 ; i<comps.size()-1 ; i++){
            for(int j=i+1; j<comps.size(); j++){
                ways+=comps.get(i).size()  * comps.get(j).size();
            }
        }
        System.out.println(ways);
    }

    public static void giveComponent(ArrayList<Edge>[]graph, int src,ArrayList<Integer>comp, boolean[] isVisited){
        isVisited[src]=true;
        comp.add(src);
        for(Edge edge:graph[src]){
            if(!isVisited[edge.nbr]) {
                giveComponent(graph, edge.nbr,comp, isVisited);
            }
        }
    }
}
