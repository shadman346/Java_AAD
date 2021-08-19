package _GenericTrees;

public class KthLargestElement {
    public static void main(String[] args) {
        CreateGenericTree tree = new CreateGenericTree();
        floor = Integer.MIN_VALUE; //largest among smallest
        ceil = Integer.MAX_VALUE;  //smallest among largest
        int k=3;
        KthLargest(tree.root,k);
    }
    static int floor;
    static int ceil;

    public static void ceilAndFloor(Node node, int data){
        if(node.data>data){
            if(node.data<ceil){
                ceil = node.data;
            }
        }
        if(node.data<data){
            if(node.data>floor){
                floor = node.data;
            }
        }
        for(Node child:node.children){
            ceilAndFloor(child,data);
        }
    }
    public static void KthLargest(Node node, int k){
        floor = Integer.MIN_VALUE;
        int factor = Integer.MAX_VALUE;
        for(int i=0; i<k; i++){
            ceilAndFloor(node,factor); //will set floor to just largest value less than factor.
            factor = floor;
            floor = Integer.MIN_VALUE;
        }
        System.out.println(factor);
    }
}
