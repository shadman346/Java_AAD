package _Graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class DFS {
    static class Edge{
        int src;
        int nbr;
        int wt;
        Edge(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt=wt;
        }
    }
    static class Path{
        String route;
        int wt;
        Path(int wt, String route){
            this.route = route;
            this.wt=wt;
        }
    }

    static class PathComparator implements Comparator<Path> {
        public int compare(Path p1, Path p2){
            if(p1.wt > p2.wt){
                return 1;
            }else if(p1.wt<p2.wt){
                return -1;
            }
            return 0;
        }
    }
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[7];
        for (int i=0; i<graph.length; i++){
            graph[i]= new ArrayList<>();
        }
        HashSet<Integer>s=new HashSet();
        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,3,40));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,2,10));

        graph[2].add(new Edge(2,1,10));
        graph[2].add(new Edge(2,3,10));

        graph[3].add(new Edge(3,0,40));
        graph[3].add(new Edge(3,2,10));
        graph[3].add(new Edge(3,4,2));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,3));
        graph[4].add(new Edge(4,6,8));

        graph[5].add(new Edge(5,4,3));
        graph[5].add(new Edge(5,6,3));

        graph[6].add(new Edge(6,4,8));
        graph[6].add(new Edge(6,5,3));


        thirdLargest.add(new Path(0,""));
        DfsSolve(graph,0,6,0,"0",40);

        System.out.println("smallestPath: "+smallestPath);
        System.out.println("largestPath: "+largestPath);
        System.out.println("jstSmaller than 40: "+jstSmallerPath);
        System.out.println("jstLarger than 40: "+jstLargerPath);
        System.out.println("3rd Largest Path: "+thirdLargest.peek().route);

    }
    //smallest path
    //largest path
    //just larger path than 40
    // just smaller path than 40
    //3rd largest path
    static int smallestWt=Integer.MAX_VALUE;
    static String smallestPath = "";
    static int largestWt = Integer.MIN_VALUE;
    static String largestPath = "";
    static int jstLarger = Integer.MAX_VALUE;   //d
    static String jstLargerPath = "";
    static int jstSmaller = Integer.MIN_VALUE;
    static String jstSmallerPath = "";
    static PriorityQueue<Path> thirdLargest = new PriorityQueue<Path>(3,new PathComparator());
    static boolean[] isVisited = new boolean[7];

    public static void DfsSolve(ArrayList<Edge>[] graph , int src , int dest, int wt , String path, int d){
        if(src==dest){
            if(wt<smallestWt){
                smallestWt = wt;
                smallestPath = path + "@" + smallestWt;
            }
            if(wt>largestWt){
                largestWt = wt;
                largestPath = path + "@" + largestWt;
            }
            if(wt>d){
                if(wt<jstLarger){
                    jstLarger = wt;
                    jstLargerPath = path + "@" + jstLarger;
                }

            }
            if(wt<d){
                if(wt>jstSmaller){
                    jstSmaller = wt;
                    jstSmallerPath = path + "@" + jstSmaller;
                }
            }
            if(wt>thirdLargest.peek().wt){
                if(thirdLargest.size()==3){
                    thirdLargest.poll();
                }
                thirdLargest.add(new Path(wt,path + "@" + wt));
            }
            return;
        }

        isVisited[src]=true;
        for (Edge edge:graph[src]){
            if(!isVisited[edge.nbr]) {
                DfsSolve(graph, edge.nbr, dest, edge.wt + wt, path + edge.nbr, d);
            }
        }
        isVisited[src]=false;
    }
}
