package HackerRank.LarrysArray.TriesContacts;

import java.util.HashMap;

/**
 * Created by jesuszarate on 2/5/17.
 */
public class Contacts {

    public static void main(String[] a) {

        Tri t = new Tri();
        t.add("hack");
        t.add("hacker");
        t.add("hackers");

        System.out.println(t.find_partial("hac"));
        System.out.println(t.find_partial("hak"));


    }
}

class Node {
    char c;
    HashMap<Character, Node> children;
    boolean complete;

    Node() {
        children = new HashMap<Character, Node>();
        complete = false;
    }
}


class Tri {
    Node root = new Node();

    void add(String contact) {

        char[] arr = contact.toCharArray();
        add(root, arr, 0);//
    }

    void add(Node current, char[] arr, int cPos) {
        if (arr.length <= cPos) {
            // Let us know that it’s a completed word
            current.children.put('*', null);
            return;
        }

        char c = arr[cPos]; //c
        if (!current.children.containsKey(c)) {
            current.children.put(c, new Node());
        }

        add(current.children.get(c), arr, ++cPos);
    }

    int find_partial(String part) {
        char[] arr = part.toCharArray();
        return find_partial(root, arr, 0);
    }

    int find_partial(Node current, char[] arr, int cPos) {

        if (cPos == arr.length) {
            //Finish everything
            if (current.children != null &&  !current.children.containsKey(arr[arr.length-1])) {
                return 0;
            } else {
                //Finish the rest
                finish(current, arr, cPos);
            }
        }

        if (current != null && current.children != null && current.children.containsKey('*')) {
            return traverse_tree(current, arr, cPos) + 1;
        }
        return traverse_tree(current, arr, cPos);
    }

    int finish(Node current, char[] arr, int cPos) {

        int tot = 0;
        if (current.children != null && current.children.containsKey('*')) {
            tot++;
        }

        else if(current.children != null) {
            for (Node n : current.children.values()) {

                tot += finish(n, arr, cPos);
            }
            return tot;
        }
        return tot;
    }

    int traverse_tree(Node current, char[] arr, int cPos) {
        int tot = 0;
        if(current != null) {
            for (Node n : current.children.values()) {

                tot += find_partial(n, arr, cPos + 1);
            }
        }
        return tot;
    }
}
