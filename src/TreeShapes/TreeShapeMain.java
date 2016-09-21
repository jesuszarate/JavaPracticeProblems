package TreeShapes;

/**
 * Created by jesuszarate on 9/9/16.
 */
public class TreeShapeMain
{
    public static void main(String[] argv){
        TreeShapes treeShapes = new TreeShapes();

        treeShapes.levelOrder(new int[]{2, 1, 7});
        System.out.println();
        treeShapes.levelOrder(new int[]{3, 5, 4});
        System.out.println();
        treeShapes.levelOrder(new int[]{7, 3, 1});
        System.out.println();
        treeShapes.levelOrder(new int[]{1, 2, 3});
    }
}
