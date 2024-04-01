package io.kowsu.algos.back_tracking;

public class LinkedList {

    Node root;

    public void add(Node node, int data) {
        if (root == null) {
            root = new Node(data);
        } else if (node.next != null) {
            add(node.next, data);
        } else {
            node.next = new Node(data);
        }
    }

    public void add(int data) {
        if (root == null) {
            root = new Node(data);
        }

        Node current = root;
        Node prev, next = current.next;

        while(current != null) {

        }
    }

    public void display(Node node) {
        if (node != null) {
            System.out.println(node.data + " -> ");
            display(node.next);
        }
    }

    public void display() {
        Node temp = root;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        linkedList.display();

    }

}

class Node {
    Node next;
    int data;

    public Node(int data) {
        this.data = data;
    }
}
