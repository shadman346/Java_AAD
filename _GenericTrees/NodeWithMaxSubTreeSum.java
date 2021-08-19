package _GenericTrees;

public class NodeWithMaxSubTreeSum {
    public static void main(String[] args) {
        CreateGenericTree tree = new CreateGenericTree();

        int ans = maxSubtreeNode(tree.root);
        System.out.println("Node: " + maxSumNode.data);
        System.out.println("Sum: "+ans);
    }
    static int maxSum = Integer.MIN_VALUE;
    static Node maxSumNode;
    public static int maxSubtreeNode(Node node){
        int sum =0;
        for(Node child: node.children){
            sum = sum + maxSubtreeNode(child);
        }
        sum +=node.data;
        if(sum > maxSum){
            maxSum = sum;
            maxSumNode = node;
        }
        return sum;
    }
}
