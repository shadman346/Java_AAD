package _Searching_Sorting;
import java.util.*;
import java.io.*;

public class MarksPCM {

    /*You have to complete the body of customSort function,
    after sorting final changes should be made in given arrays only. */
    static class Student implements Comparable<Student>{
        int p;
        int c;
        int m;
        Student(int p,int c,int m){
            this.p=p;
            this.c=c;
            this.m=m;
        }

        @Override
        public int compareTo(Student s2) {
            if(this.p>s2.p){
                return 1;
            }else if (this.p==s2.p){
                if(this.c<s2.c){
                    return 1;
                }else if(s2.c==this.c){
                    return this.m-s2.m;
                }
            }
            return -1;
        }
    }
    public static void customSort(int[]phy,int[]chem,int[]math) {
        //write your code here
        List<Student> students = new ArrayList();
        for (int i=0;i<phy.length;i++){
            students.add(new Student(phy[i],chem[i],math[i]));
        }
        Collections.sort(students);
        for(int i=0;i<phy.length;i++) {
            Student s = students.get(i);
            System.out.println(s.p+ " " + s.c + " " + s.m);
        }

    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);

        //input work
        int N = scn.nextInt();

        int[]phy = new int[N];
        int[]chem = new int[N];
        int[]math = new int[N];

        for(int i=0; i < N;i++) {
            phy[i] = scn.nextInt();
        }

        for(int i=0; i < N;i++) {
            chem[i] = scn.nextInt();
        }

        for(int i=0; i < N;i++) {
            math[i] = scn.nextInt();
        }

        customSort(phy,chem,math);

        //output

    }
}
