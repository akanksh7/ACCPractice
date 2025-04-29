import java.util.*;

public class LinkedList
{
    static class Node 
    {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }	
    }
    Node head;
	void push(int newData) 
    {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
	} 
    void detectLoopAndPrint() 
    {
        Node slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) 
        {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) 
            {
                System.out.println("Loop found");
                return;
            }
        }
        System.out.println("Loop not found");
	}
    public static void main(String[] args) 
    {
        LinkedList list = new LinkedList();
        list.push(20);
        list.push(41);
        list.push(5);
        list.push(10);
        list.head.next.next.next.next = list.head;
        list.detectLoopAndPrint();
    }
}

}