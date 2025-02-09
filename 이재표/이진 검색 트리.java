import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        Node left;
        Node right;
        int key;

        public Node(int key) {
            this.key = key;
        }

        public void insert(int key) {
            if (key < this.key) {
                if (this.left == null) {
                    this.left = new Node(key);
                } else {
                    this.left.insert(key);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(key);
                } else {
                    this.right.insert(key);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        while (true) {
            String in = br.readLine();
            if (in == null || in.equals("")) {
                break;
            }
            root.insert(Integer.parseInt(in));
        }
        postOrder(root);
    }

    private static void postOrder(Node root) {
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.key);
    }
}
