package _recurssion;

public class ToweOfHanoi {

    public static void main(String[] args){
        int tower1 = 10 , tower2 = 11, tower3 = 12;
        int disk =3;
        int diskInTower = tower1;
        int towerWhereDiskTransfer = tower2;
        int towerToHelpDiskTransfer = tower3;
        toh(disk,diskInTower,towerWhereDiskTransfer,towerToHelpDiskTransfer);
    }
    public static void toh(int x , int A , int B, int C){
        if(x==0) return;
        toh(x-1 , A , C ,B);
        System.out.println(x + "[" + A + "->" + B + "]");
        toh(x-1, C, B, A);
    }


}
