import java.util.*;

// Loop Detection Using Hashing T - O(n)  S - O(n)
public class LinkedList 
{
    static Node head;
    static class Node 
    {
        int data;
        Node next;
        Node(int d) 
        {
            data = d;
            next = null;
        }
    }
    static public void push(int new_data) 
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }
    static boolean detectLoop(Node h) 
    {
        HashSet < Node > s = new HashSet < Node > ();
        while (h != null) 
        {

            if (s.contains(h))
                return true;

            s.add(h);

            h = h.next;
        }

        return false;
    }
    public static void main(String[] args) 
    {
        LinkedList llist = new LinkedList();
        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(10);
        llist.head.next.next.next.next = llist.head;
        if (detectLoop(head))
        System.out.println("Loop Exists");
        else
        System.out.println("Loop doesn't exists");
    }
}
