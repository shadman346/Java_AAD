package _binaryTree;

import java.util.Stack;

public class ConstructorBinaryTree {

    static class Pair{
        Node node;
        int state;
        Pair(Node node, int state){
            this.node =node;
            this.state=state;
        }
    }

    public static Node rootBt() {
        Integer[] arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
        Node root = new Node(50);
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root,1));

        int idx = 0;
        while(!st.isEmpty()){
            Pair top = st.peek();
            if(top.state==1){
                idx++;
                if(arr[idx]!=null){
                    top.node.left = new Node(arr[idx]);
                    st.push(new Pair(top.node.left,1));
                }
                top.state++;
            }else if(top.state==2){
                idx++;
                if(arr[idx]!=null){
                    top.node.right = new Node(arr[idx]);
                    st.push(new Pair(top.node.right,1));
                }
                top.state++;
            }else{
                st.pop();
            }
        }
        return root;
    }
}
