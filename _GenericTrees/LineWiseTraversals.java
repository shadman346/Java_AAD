package _GenericTrees;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class LineWiseTraversals {
    public static void display(Node node){
        StringBuilder str = new StringBuilder(node.data + " -> ");
        for(Node child:node.children){
            str.append(child.data).append(",");
        }
        str.append(".");
        System.out.println(str);
        for(Node child:node.children){
            display(child);
        }
    }
    // 1 using queue
    public static void levelOrderLineWise(Node node){
        Queue<Node> levelQueue = new ArrayDeque<>();
        levelQueue.add(node);

        Queue<Node> childrenQueue = new ArrayDeque<>();
        while(!levelQueue.isEmpty()){
            node = levelQueue.remove();
            System.out.print(node.data + " ");
            for (Node child: node.children){
                childrenQueue.add(child);
            }
            if(levelQueue.isEmpty()){
                //move next level
                levelQueue = childrenQueue;
                childrenQueue = new ArrayDeque<>();
                System.out.println();
            }
        }
    }

    // 2  using stack
    public static void levelOrderLineWiseZigZag(Node node){
        Stack<Node> levelStack = new Stack<>();
        levelStack.push(node);
        Stack<Node> childrenStack = new Stack<>();

        int level =0;
        while(!levelStack.isEmpty()){
            node = levelStack.pop();
            System.out.print(node.data + " ");
            if(level % 2 == 0){
                for(int i=0 ; i<node.children.size();i++){
                    Node child = node.children.get(i);
                    childrenStack.add(child);
                }
            }else{
                for(int i=node.children.size()-1 ; i>=0;i--){
                    Node child = node.children.get(i);
                    childrenStack.add(child);
                }
            }

            if(levelStack.isEmpty()){
                levelStack = childrenStack;
                childrenStack = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }

    //3 using only 1 queue
    public static void levelOrderLineWise3(Node node){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        queue.add(new Node(-1));

        while(!queue.isEmpty()){
            node = queue.remove();
            if(node.data!=-1) {
                System.out.print(node.data + " ");
                queue.addAll(node.children);
            }else if(queue.isEmpty()){
                //do nothing
            }else {
                //move next level
                queue.add(new Node(-1));
                System.out.println();
            }
        }
    }
    //4  using 1 queue + count size method
    public static void levelOrderLineWise4(Node node){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=1 ; i<=size;i++){
                node = queue.remove();
                System.out.print(node.data + " ");
                for(int it=0; it<node.children.size();it++){
                    Node child = node.children.get(it);
                    queue.add(child);
                }
            }
            System.out.println();
        }
    }

    // 5 we need to make pair class that will encapsulate level and Node
    static class pair{
        Node node;
        int level;
        pair(Node x,int y){
            this.node = x;
            this.level = y;
        }
    }
    public static void levelOrderLineWise5(Node node){
        Queue<pair> queue = new ArrayDeque<>();
        queue.add(new pair(node,1));
        int level = 1;
        while(!queue.isEmpty()){
            pair p = queue.remove();
            if(p.level>level){
                level = p.level;
                System.out.println();
            }
            System.out.print(p.node.data + " ");
            for (Node child:p.node.children){
                queue.add(new pair(child,p.level +1));
            }

        }
    }
    public static void main(String[] args) {

        CreateGenericTree tree = new CreateGenericTree();
        Node root = tree.root;
        levelOrderLineWise5(root);
    }
}
