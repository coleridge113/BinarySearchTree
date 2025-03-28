package org.bst;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(new Node(5));
        tree.insert(new Node(8));
        tree.insert(new Node(2));
        tree.insert(new Node(6));
        tree.insert(new Node(1));
        tree.insert(new Node(3));
        tree.insert(new Node(10));
        tree.insert(new Node(4));
        tree.insert(new Node(7));

        tree.displayGraphically();

        tree.remove(2);
        System.out.println('\n');

        tree.displayGraphically();

    }
}