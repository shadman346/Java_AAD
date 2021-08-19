package _TEST_JAVA_STL;

import java.util.*;

public class Main {
    static interface Z {
        int z = 99;
        int add(int x , int y);
        int sub(int x , int y);
    }


    static class X implements Z,Comparator<Integer> {
        int x = -1;
        X(){
            System.out.println("X created");
        }
        @Override
        public int add(int x, int y) {
            return (x+y) * this.x;
        }

        @Override
        public int sub(int x, int y) {
            return (x-y) * x;
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            return 0;
        }
    }

    static class A{
        int i;
         A(int x){
             System.out.println(x*x);
        }
    }

    static class B extends A {

        B(int x) {
            super(x*x);
            System.out.println("i am b");
        }
    }

    static class C extends A{


        C(int x) {
            super(x*x);
            System.out.println("i am c");
        }
    }


    public static void main(String[] args) {
        ArrayList<Integer> arr =new ArrayList<>(); //1
        HashMap<Integer,Integer> map = new HashMap<>(); //2
        Queue<Integer> queue = new ArrayDeque<>(); //3
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //4
        HashSet<Integer> set = new HashSet<>(); //5
        Stack<Integer> stack = new Stack<>(); //6
        /** inputs */
        arr.add(1);
        map.put(1,2);
        queue.add(3);
        pq.add(4);
        set.add(5);
        stack.add(6); // push() also there
        HashMap<Integer,Integer> s = new HashMap<>();
        s.putAll(map);
        s.put(3,10);
//        /** index */
//        arr.get(0);
//        map.get(1);
//        queue.peek();
//        pq.peek();
//        // set nothing
//        stack.peek();
//        /** remove */
//        arr.remove(0);
//        map.remove(0);
//        queue.remove(); // throw exception when empty
//        queue.poll(); // return null when empty
//        pq.poll(); // remove() also there
//        set.remove(5); // remove object;
//        stack.pop();
//        /** contains */
//        arr.contains(1);
//        map.containsKey(2);
//        map.containsValue(2);
//        queue.contains(3);
//        pq.contains(4);
//        set.contains(5);
//        stack.contains(6);
//        // containsAll() special function that searches for whole collection
//        /** iteration */
        for(Map.Entry m: map.entrySet()){
            int value = (Integer)m.getValue();
            int key = (Integer)m.getKey();
            s.put((Integer)m.getValue(),23);
        }
        String str = "qwerty";
        StringBuilder st = new StringBuilder(str);
        ArrayList<Integer>[][] dp = new ArrayList[3][3];
        ArrayList<Integer> t = new ArrayList<>();
        System.out.println(t);
//        System.out.println(st.substring(0,3));








    }

}
