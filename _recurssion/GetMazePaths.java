package _recurssion;

import java.util.ArrayList;

public class GetMazePaths {
    public static void main(String[]args){
        int startRow=0,startCol=0,endRow=2,endCol=2;
        System.out.println(getPaths(startRow,startCol,endRow,endCol));
    }

    public static ArrayList<String> getPaths(int xstart,int ystart, int xend, int yend){
        if(xstart==xend && ystart==yend){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        };

        ArrayList<String> allPaths = new ArrayList<>();
        if(ystart!=yend) {
            ArrayList<String> paths1 = getPaths(xstart, ystart + 1, xend, yend); //move horizontal-right
            for (String path : paths1) {
                allPaths.add("h" + path);
            }
        }
        if(xstart!=xend) {
            ArrayList<String> paths2 = getPaths(xstart + 1, ystart, xend, yend); //move vertical-down
            for (String path : paths2) {
                allPaths.add("v" + path);
            }
        }

        return allPaths;


    }
}
