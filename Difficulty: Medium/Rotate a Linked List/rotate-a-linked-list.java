//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


// } Driver Code Ends
/* node of linked list:

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

*/

class Solution {
    // Function to rotate the ArrayList by one position
    public void rotate(ArrayList<Integer> arr) {
        int first = arr.remove(0); // Remove the first element
        arr.add(first); // Add the removed element to the end
    }
    
    // Function to rotate the ArrayList by k positions
    public void kRotate(ArrayList<Integer> arr, int k) {
        for (int i = 0; i < k; i++) {
            rotate(arr);
        }
    }
    
    // Function to rotate the linked list by k positions
    public Node rotate(Node head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        
        // Convert linked list to ArrayList
        ArrayList<Integer> arr = new ArrayList<>();
        Node temp = head;
        while (temp != null) {
            arr.add(temp.data);
            temp = temp.next;
        }
        
        // Perform the rotation
        kRotate(arr, k);
        
        // Convert the ArrayList back to a linked list
        Node nhead = new Node(arr.get(0));
        Node current = nhead;
        for (int i = 1; i < arr.size(); i++) {
            current.next = new Node(arr.get(i));
            current = current.next;
        }
        
        return nhead;
    }
}


//{ Driver Code Starts.

public class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            if (!input.isEmpty()) {
                String[] numbers = input.split("\\s+");
                for (String num : numbers) {
                    if (!num.isEmpty()) {
                        arr.add(Integer.parseInt(num));
                    }
                }
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); ++i) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            head = ob.rotate(head, k);
            printList(head);
        }
    }
}

// } Driver Code Ends