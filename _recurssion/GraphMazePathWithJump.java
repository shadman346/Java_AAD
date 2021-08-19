package _recurssion;

import java.util.ArrayList;

public class GraphMazePathWithJump {
    public static void main(String[]args){
        System.out.println(getPaths(0,0,2,2));
    }
    //we an move horizontal,vertical and diagonal with jumps
    public static ArrayList<String> getPaths(int rstart, int cstart, int rend, int cend){
        if(rstart==rend && cstart==cend){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        };

        ArrayList<String> allPaths = new ArrayList<>();

        if(rstart!=rend){
            for(int i=1 ;i<=rend-rstart; i++ ) {
                ArrayList<String> pathsVt = getPaths(rstart + i, cstart, rend, cend);
                for(String path:pathsVt){
                    allPaths.add(i+"v"+path);
                }
            }

        }
        if(cstart!=cend){
            for(int i=1 ;i<=cend-cstart; i++ ) {
                ArrayList<String> pathsHz = getPaths(rstart , cstart+i, rend, cend);
                for(String path:pathsHz){
                    allPaths.add(i+"h"+path);
                }
            }
        }
        if(rstart!=rend && cstart!=cend){
            int jump = (rend<cend)? rend-rstart : cend-cstart ;
            for(int i=1 ;i<=jump; i++ ) {
                ArrayList<String> pathsDg = getPaths(rstart + i, cstart+i, rend, cend);
                for(String path:pathsDg){
                    allPaths.add(i+"d"+path);
                }
            }
        }

        return allPaths;
    }
}
