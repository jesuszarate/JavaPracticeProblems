package LeetCode;

import java.util.HashSet;

public class RegExMatching {
    class Node{
        String data;
        HashSet<Node> children;
        public Node(String data){
            this.data = data;
        }
    }

    public boolean isMatch(String s, String p) {
        return false;
    }

    public Node buildTree(String p){
        Node root = new Node("Root");

        Node current = root;
        for(int i = 0; i < p.length(); i++){

            if(p.charAt(i) == '*'){
                current.children.add(current);
            }
            else if(p.charAt(i) == '.'){

            }
            else{
                current.children.add(new Node(p.charAt(i) + ""));
            }
            if(i == p.length() - 1){
                current.children.add(new Node("Goal"));
            }
        }
        return root;
    }
}
