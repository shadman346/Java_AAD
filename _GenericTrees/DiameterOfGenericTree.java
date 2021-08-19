package _GenericTrees;

public class DiameterOfGenericTree {
    public static void main(String[] args) {
        CreateGenericTree tree = new CreateGenericTree();
        findDiameter(tree.root);
        System.out.println(dia);
    }
    static int dia = 0;
    public static int findDiameter(Node node){
        int deepest = -1;
        int secDeepest = -1;

        for (Node child: node.children){
            int ch = findDiameter(child);
            if(ch>deepest){
                secDeepest = deepest;
                deepest = ch;
            }else if(ch > secDeepest){
                secDeepest = ch;
            }
        }

        if(deepest + secDeepest + 2 > dia){
            dia = deepest + secDeepest + 2;
        }
        deepest++;
        return deepest;
    }
}
