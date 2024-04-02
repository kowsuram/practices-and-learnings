package io.kowsu.algos;

/*
    @created March/27/2024 - 2:47 PM
    @project spring-boot-web
    @author k.ramanjineyulu
*/


public class LinkedList {

    public static void main(String[] args) {
        Node root = new Node(0);
        LinkedList list = new LinkedList();
        list.add(root, 1);
        list.add(root, 2);
        list.add(root, 3);

        list.display(root);

        Node node = list.reverse(root);

        System.out.println("Reversed list \n");

        list.display(node);

    }

    public void add(Node node, int data) {
        if (node.next != null) {
            add(node.next, data);
        } else {
            node.next = new Node(data);
        }
    }

    public void display(Node node) {
        if (node != null) {
            System.out.print(node.data + "" +  (node.next != null ? " -> " : "-> null"));
            display(node.next);
        }
    }

    // head                 tail
    // 1 -> 2 -> 3 -> 4 - > null

    //tail                  head
    //null <- 1 <- 2 <- 3 <- 4

    public Node reverse(Node node) {
        Node prev = null, next = null, current = node;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

}


class Node {
    Node next;
    Integer data;

    Node(Integer data) {
        this.data = data;
    }
}
