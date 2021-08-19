package _GenericTrees;

import java.util.Iterator;
import java.util.Stack;

public class IterableAndIterator {
    static class GenericTree implements Iterable<Integer>{
        Node root;
        GenericTree(Node root){
            this.root = root;
        }

        public Iterator<Integer> iterator() {
            Iterator<Integer> obj = new GtPreorderIterator(root);
            return obj;
        }
    }

    static class Pair{
        Node node;
        int state;
        Pair(Node node , int state){
            this.node = node;
            this.state = state;
        }
    }

    static class GtPreorderIterator implements Iterator<Integer>{
        Integer nval;   // Integer work like a reference holding instance of an int , so it can also be null
        Stack<Pair> stack;

        public GtPreorderIterator(Node root){
            stack = new Stack<>();
            stack.push(new Pair(root,-1));
            next();
        }

        public boolean hasNext() {
            return nval != null;
        }

        public Integer next(){
            Integer fr = nval;
            nval = null;

            // iterative PreOrder using stack
            while (stack.size()>0){
                Pair top = stack.peek();
                if(top.state == -1){
                    nval = top.node.data;
                    top.state++;
                    break;
                }else if(top.state == top.node.children.size()){
                    stack.pop();
                }else{
                    Pair childPair = new Pair(top.node.children.get(top.state),-1);
                    stack.push(childPair);
                    top.state++;
                }
            }
            return fr;
        }
    }
    public static void main(String[] args) {
        CreateGenericTree tree = new CreateGenericTree();

        GenericTree root = new GenericTree(tree.root);

        for (int val : root) {
            System.out.println(val);
        }

//        Iterator<Integer> gti = root.iterator();
//        while (gti.hasNext()){
//            System.out.println(gti.next());
//        }

    }
}
