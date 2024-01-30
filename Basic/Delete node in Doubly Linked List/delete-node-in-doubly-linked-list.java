//{ Driver Code Starts
//Initial Template for Java
import java.util.*;

class Node
{
	int data;
	Node next;
	Node prev;
	Node(int d)
	{
		data = d;
		next = prev = null;
	}
}
class Delete_Node_From_DLL
{
	Node head;
	Node tail;
	
	void addToTheLast(Node node)
	{
		if(head ==  null)
		{
			head = node;
			tail = node;
		}
		else
		{
			tail.next = node;
			tail.next.prev = tail;
			tail = tail.next;
		}
	}
	
	void printList(Node head)
	{	Node temp = head;
		while(temp != null)
		{
			System.out.print(temp.data+" ");
			temp =  temp.next;
		}
		System.out.println();
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			Delete_Node_From_DLL list = new Delete_Node_From_DLL();
			
			int a1 = sc.nextInt();
			Node head = new Node(a1);
			list.addToTheLast(head);
			
			for(int i=1;i<n;i++)
			{
				int a = sc.nextInt();
				list.addToTheLast(new Node(a));
			}
			a1 = sc.nextInt();
			Solution g = new Solution();
			//System.out.println(list.temp.data);
			Node ptr = g.deleteNode(list.head, a1);
			list.printList(ptr);
			t--;
		}
	}
}


                               
// } Driver Code Ends


//User function Template for Java

/* Structure of linkedlist node
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int d)
	{
		data = d;
		next = prev = null;
	}
}
*/
class Solution
{
    // function returns the head of the linkedlist
    Node deleteHead(Node head){
        Node temp = head;
        if(head == null || head.next == null) return null;
        head = head.next;
        head.prev = null;
        temp.next = null;
        return head;
    }
    Node deleteTail(Node head){
        if(head == null || head.next == null) return null;
        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        Node temp = tail.prev;
        temp.next = null;
        tail.prev = null;
        return head;
    }
    Node deleteNode(Node head,int x)
    {
	// Your code here
	    if(head == null || head.next == null) return null;
	    int cnt = 0;
	    Node temp = head;
	    if(x == 1){
	        head = head.next;
	        head.prev = null;
	        return head;
	    }
	    while(temp != null){
	        cnt++;
	        if(cnt == x) break;
	        temp = temp.next;
	    }
	    Node temp1 = temp.prev;
	    Node temp2 = temp.next;
	    if(temp1 == null && temp2 == null) return null;
	    else if(temp2 == null) return deleteTail(head);
	    else if(temp1 == null) return deleteHead(head);
	    else{
	        temp1.next = temp2;
	        temp2.prev = temp1;
	        temp.next = null;
	        temp.prev = null;
	    }
	    return head;
    }
}
