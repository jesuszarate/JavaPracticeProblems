package TreeShapes;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by jesuszarate on 9/9/16.
 */
public class TreeShapes
{

    public void levelOrder(int[] array){
        Node rootNode = buildTree(array);

        //levelOrderRec(rootNode);
        breadthFirstSearch(rootNode);
    }

    public void breadthFirstSearch(Node root){

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);

        while (!queue.isEmpty()){

            Node current = queue.remove();
            System.out.println(current.data + " " + current.pos);

            if(current.leftChild != null){
                queue.offer(current.leftChild);
            }
            if(current.rightChild != null){
                queue.offer(current.rightChild);
            }
        }

    }

    public Node buildTree(int[] array){
        Node rootNode = new Node(array[0]);

        for (int i = 1; i < array.length; i++){
            buildTree(rootNode, new Node(array[i]));
        }

        return rootNode;
    }

    public void buildTree(Node current, Node newNode){

        // Go right
        if(newNode.data > current.data){
            if(current.rightChild == null){
                current.rightChild = newNode;
                newNode.parent = current;
                newNode.pos = (2*current.pos) + 2;
            }
            else buildTree(current.rightChild, newNode);
        }
        // Go left
        else if(newNode.data <= current.data){
            if(current.leftChild == null){
                current.leftChild = newNode;
                newNode.parent = current;
                newNode.pos = (2*current.pos) + 1;
            }
            else buildTree(current.leftChild, newNode);
        }
    }

    public class Node{
        public int data;
        public int pos;
        public Node parent;
        public Node leftChild;
        public Node rightChild;

        public Node(int data){
            this.data = data;
        }

    }
}
