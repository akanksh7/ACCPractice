import java.util.*;

class Solution 
{
    public static Node merge(Node head1, Node head2)
    {
        Node merged = new Node(-1);
        Node temp = merged;
        while (head1 != null && head2 != null) 
        {
            if (head1.data < head2.data) 
            {
                temp.next = head1;
                if(temp.data != -1) head1.prev = temp;
                head1 = head1.next;
            }
            else 
            {
                temp.next = head2;
                if(temp.data != -1) head2.prev = temp;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        while (head1 != null) 
        {
            temp.next = head1;
            head1.prev = temp;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) 
        {
            temp.next = head2;
            head2.prev = temp;
            head2 = head2.next;
            temp = temp.next;
        }
        return merged.next;
    }
    //2.FIND THE MID POINT

    public static Node find_mid(Node head)
    {
        Node slow = head, fast = head.next;
        while(slow != null && fast != null)
        {
            fast = fast.next;
            if(fast == null) break;
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public static Node mergesort(Node head)
    {
        if(head.next == null) return head;
        Node mid = find_mid(head);
        Node head1 = head;
        Node head2 = mid.next;
        mid.next = null;
        head2.prev = null;
        head1 = mergesort(head1);
        head2 = mergesort(head2);
        return merge(head1, head2);
    }
}

class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = null;
        prev = null;
    }
}

class LinkedList
{
    Node head;
    void add(int data)
    {
        Node new_node = new Node(data);
        if(head == null)
        {
            head = new_node;
            return;
        }
        Node curr = head;
        while(curr.next != null) curr = curr.next;
        curr.next = new_node;
        new_node.prev = curr;
    }
}

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        LinkedList a = new LinkedList();
        for(int i = 0; i < n; i++)
        {
            a.add(input.nextInt());
        }
        Solution Obj = new Solution();
        a.head = Obj.mergesort(a.head);
        Node h = a.head;
        while(h != null)
        {
            System.out.print(h.data + " ");
            h = h.next;
        }
        System.out.println("");
    }
}

public class DLLMergeSort 
{
    private Node head;
    public DLLMergeSort() 
    {
        this.head = null;
    }
    public class Node 
    {
        int data;
        Node prev, next;

        public Node(int data) 
        {
            this.data = data;
            this.prev = this.next = null;
        }
    }
    private Node merge(Node left, Node right) 
    {
        if (left == null) return right;
        if (right == null) return left;
        if (left.data < right.data) 
        {
            left.next = merge(left.next, right);
            if (left.next != null) 
            {
                left.next.prev = left;
            }
            left.prev = null;
            return left;
        } 
        else 
        {
            right.next = merge(left, right.next);
            if (right.next != null) 
            {
                right.next.prev = right;
            }
            right.prev = null;
            return right;
        }
    }
    private Node getMiddle(Node head) 
    {
        if (head == null) 
        {
            return null;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) 
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public Node mergeSort(Node node) 
    {
        if (node == null || node.next == null) 
        {
            return node;
        }
        Node middle = getMiddle(node);
        Node nextOfMiddle = middle.next;
        middle.next = null;
        nextOfMiddle.prev = null;
        Node left = mergeSort(node);
        Node right = mergeSort(nextOfMiddle);
        return merge(left, right);
    }
    public void printList(Node node) 
    {
        while (node != null) 
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public void insert(int data) 
    {
        Node newNode = new Node(data);
        if (head == null) 
        {
            head = newNode;
        } 
        else 
        {
            Node temp = head;
            while (temp.next != null) 
            {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }
    public static void main(String[] args) 
    {
        DLLMergeSort dll = new DLLMergeSort();
        dll.insert(12);
        dll.insert(11);
        dll.insert(13);
        dll.insert(5);
        dll.insert(6);
        dll.insert(7);
        System.out.println("Original DLL:");
        dll.printList(dll.head);
        dll.head = dll.mergeSort(dll.head);
        System.out.println("DLL after Merge Sort:");
        dll.printList(dll.head);
    }
}                           