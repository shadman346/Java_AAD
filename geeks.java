import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class geeks {
    public static void main(String[] args) {
        int N = 5;
        int[][]edges= {{1, 2},
                {1, 3},
                {2, 4},
                {2, 5},
                {3, 6}};

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i=0; i<N; i++){
            ArrayList<Integer> ed = new ArrayList<>();
            ed.add(edges[i][0]);
            ed.add(edges[i][1]);
            list.add(ed);
        }
        geeks o = new geeks();
        int ans = o.maxPoints(list);
        System.out.println(ans);
    }


    int maxPoints(ArrayList<ArrayList<Integer>> edges)
    {
        //code here.
        if(edges.isEmpty())return 1;
        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();
        for (ArrayList<Integer> e : edges) {
            int v1 = e.get(0);
            int v2 = e.get(1);
            if (!graph.containsKey(v1)) {
                graph.put(v1, new ArrayList<>());
            }
            if (!graph.containsKey(v2)) {
                graph.put(v2, new ArrayList<>());
            }
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }


        int points = Integer.MIN_VALUE;
        for (Map.Entry<Integer, ArrayList<Integer>> set : graph.entrySet()) {
            if(set.getValue().size()==1) {
                int p;
                p = solution(graph, set.getKey(),-1).point;
                points = Math.max(points, p);
            }
        }
        return points;
    }

    int totalScore=0;
    class Pair{
        int point;
        int unVisited;
    }
    HashMap<Integer,Pair> dp = new HashMap<>();
    Pair solution(HashMap<Integer, ArrayList<Integer>> graph,int src, int parent) {
        int dir = src*10000 + parent;
        if(dp.containsKey(dir)){
            return dp.get(dir);
        }
        ArrayList<Integer> nbrs = graph.get(src);
        int unVisited=0;
        int point=0;
        for(int nbr:nbrs){
            if(nbr!=parent) {
                Pair p;
                p = solution(graph, nbr,src);
                unVisited+=p.unVisited;
                point+=p.point;
            }
        }

        point+= unVisited+1;
        Pair res=new Pair();
        res.point=point;
        res.unVisited=unVisited+1;
        dp.put(dir,res);
        return res;
    }
}
