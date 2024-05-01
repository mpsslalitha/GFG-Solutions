//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    Node head = null, tail = null;
		    
		    char head_c = sc.next().charAt(0);
		    head = new Node(head_c);
		    tail = head;
		    
		    while(n-- > 1){
		        tail.next = new Node(sc.next().charAt(0));
		        tail = tail.next;
		    }
		    
		    Solution obj = new Solution();
		    //show(head);
		    show(obj.arrangeCV(head));
		    
		}
	}
	
	public static void po(Object o){
	    System.out.println(o);
	}
	
	public static void show(Node head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/*
Structure of node class is:
class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    
    public Node arrangeCV(Node head){
        //write code here and return the head of changed linked list
        ArrayList<Character> a=new ArrayList<>();
        ArrayList<Character> b=new ArrayList<>();
        Node temp=head;
        while(temp!=null){
            if(temp.data=='a'|| temp.data=='e' || temp.data=='i'|| temp.data=='o'|| temp.data=='u'){
                a.add(temp.data);
            }
            else{
                b.add(temp.data);
            }
            temp=temp.next;
        }
        Node x=new Node('x');
        Node y=x;
        for(int i=0;i<a.size();i++){
            Node z=new Node(a.get(i));
            y.next=z;
            y=y.next;
        }
         for(int i=0;i<b.size();i++){
            Node z=new Node(b.get(i));
            y.next=z;
            y=y.next;
        }
        return x.next;
    }
}