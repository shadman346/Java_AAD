package _random;

import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {

        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();
        while(T!=0){
            int size = scn.nextInt();
            int[] arr = new int[size];
            for(int i=0; i<size ;i++){
                arr[i] = scn.nextInt();
                
            }
            int itridx = 0;
            int lidx = 0;
            int hidx =0;
            int count =1;
            if(size==1){
                System.out.println(0);
            }
            for(int i=1; i<size ; i++ ){

                if(arr[i]>=arr[i-1]){
                    count++;
                }else{
                    if(count>(hidx-lidx+1)){
                        lidx=itridx;
                        hidx=i-1;
                    }
                    itridx=i;
                    count =1;
                }
            }
            if(count>(hidx-lidx+1)){
                lidx=itridx;
                hidx=size-1;
            }

            int operation=0;
            operation+=lidx-0;
            operation+=size-1-hidx;
            System.out.println(operation);
        }

        T++;
    }
}