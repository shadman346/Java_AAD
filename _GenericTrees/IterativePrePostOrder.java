package _GenericTrees;

import java.util.Stack;

public class IterativePrePostOrder {
    // state -> put in stack with node to determine the behavior
    // -1 -> Preorder , state++
    // equal to Children size() -> Postorder , pop
    // 0 to children.size()   -> childPush , state++
    static class pair {
        Node node;
        int state;
        pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }
    public static void main(String[] args) {
        CreateGenericTree tree = new CreateGenericTree();
        IterativePreAndPostOrder(tree.root);
    }

    public static void IterativePreAndPostOrder(Node node){
        Stack<pair> stack = new Stack<>();
        stack.push(new pair(node,-1));

        StringBuilder pre = new StringBuilder();
        StringBuilder post = new StringBuilder();
        while (stack.size()>0){
            pair top = stack.peek();
            if(top.state==-1){
                pre.append(top.node.data).append(" ");
                top.state++;
            }else if(top.state == top.node.children.size()){
                post.append(top.node.data).append(" ");
                stack.pop();
            }else{
                pair childPair = new pair(top.node.children.get(top.state),-1);
                stack.push(childPair);
                top.state++;
            }
        }
        System.out.println(pre);
        System.out.println(post);
    }
}
