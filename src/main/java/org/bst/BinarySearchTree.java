package org.bst;

public class BinarySearchTree {
    Node root;

    public void insert(Node node) {

        root = insertHelper(root, node);

    }

    private Node insertHelper(Node root, Node node) {

        int data = node.data;

        if (root == null) {
            root = node;
            return root;
        } else if (data < root.data) {
            root.left = insertHelper(root.left, node);
        } else {
            root.right = insertHelper(root.right, node);
        }

        return root;
    }

    public void display() {
        displayHelper(root);
    }

    private void displayHelper(Node root) {

        // Inorder Traversal
        if (root != null) {
            displayHelper(root.left);
            System.out.println(root.data);
            displayHelper(root.right);
        }
    }

    public void displayGraphically() {
        displayGraphicallyHelper(root, 0);
    }

    // Helper method to recursively display the tree structure
    private void displayGraphicallyHelper(Node root, int level) {
        if (root != null) {
            displayGraphicallyHelper(root.right, level + 1); // Process the right subtree first
            System.out.println("    ".repeat(level) + root.data); // Indent based on the level and print the current
                                                                  // node
            displayGraphicallyHelper(root.left, level + 1); // Process the left subtree
        }
    }

    public boolean search(int data) {
        return searchHelper(root, data);
    }

    private boolean searchHelper(Node root, int data) {
        if (root == null) {
            System.out.println("Not Found: " + data);
            return false;
        } else if (root.data == data) {
            System.out.println("Found: " + data);
            return true;
        } else if (data < root.data) {
            return searchHelper(root.left, data);
        } else {
            return searchHelper(root.right, data);
        }
    }

    public void remove(int data) {
        if(search(data)){
            removeHelper(root, data);
        } else {
            System.out.println(data + " could not be found");
        }
    }

    public Node removeHelper(Node root, int data) {
        if(root == null){
            return root;
        } else if (data < root.data){
            root.left = removeHelper(root.left, data);
        } else if (data > root.data){
            root.right = removeHelper(root.right, data);
        } else {
            if(root.left == null && root.right == null){
                root = null;
            } else if (root.right != null){
                root.data = successor(root);
                root.right = removeHelper(root.right, root.data);
            } else {
                root.data = predecessor(root);
                root.left = removeHelper(root.left, root.data);
            }
        }

        return root;
    }

    private int successor(Node root) {
        root = root.right;
        while(root.left != null){
            root = root.left;
        }
        return root.data;
    }

    private int predecessor(Node root) {
        root = root.left;
        while(root.right != null){
            root = root.right;
        }
        return root.data;
    }
}
