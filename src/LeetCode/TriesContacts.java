package LeetCode;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TriesContacts {

    static class Node{
        Character letter;
        HashMap<Character, Node> children;

        public Node(Character name){
            this.letter = name;
            children = new HashMap<Character, Node>();
        }
    }

    public static void main(String[] args) {
        //ArrayList<String> input =
        String[] input = {
                "add hack",
                "add hacker",
                "find hac",
                "find hak"};

        Scanner in = new Scanner(System.in);
        int n = input.length; // Number of operations to perform

        Node root = new Node('~');
        int totCount = 0;
        // The operations to perform
        for(int a0 = 0; a0 < n; a0++){
            String[] next = input[a0].split(" ");
            String op = next[0];
            String contact = next[1];

            if (op.equals("add")) addName(contact, root);
            else {
                totCount += findPartial(contact, root);
            }
        }
        System.out.println(totCount);
    }

    // root chldn[('h', ~h~)]
    // ~h~ ->chldn[('a', ~a~)]
    // ~a~ ->chldn[('c', ~c~)]
    // ~c~ ->chldn[('k', ~k~)]
    // ~k~ ->chldn[('*', ~*~), ('e', ~e~)]

    // hack // hacker
    // current = ~root~, ~h~, ~a~
    public static void addName(String name, Node root){

        Node current = root; // root, ~c~, ~k~, ~e~
        for(int i = 0; i < name.length(); i++){ // at(i) = k, e
            if(!current.children.containsKey(name.charAt(i))){
                // Add it as a child
                current.children.put(name.charAt(i), new Node(name.charAt(i)));
            }
            current = current.children.get(name.charAt(i));
        }
        if(!current.children.containsKey('*')){
            current.children.put('*', new Node('*'));
        }
    }

    public static int findPartial(String part, Node root){
        Node currentNode = findPartRoot(part, root);

        // Do a DFS
        return findCount(currentNode);
    }

    public static int findCount(Node current){

        // Base Case
        if(current == null) return 0;

        int count = 0;
        if(current.children.containsKey('*')) count++;

        for(Node child : current.children.values()){
            count += findCount(child);
        }

        return count;
    }

    //hac
    public static Node findPartRoot(String part, Node root){

        Node current = root;// ~root~
        for(int i = 0; i < part.length(); i++){
            char c = part.charAt(i);
            if(current == null) return null;
            current = current.children.getOrDefault(c, null);
        }
        return current;
    }
}