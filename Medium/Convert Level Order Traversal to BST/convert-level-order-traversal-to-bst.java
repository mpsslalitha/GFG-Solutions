//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Main {
    
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            GFG obj = new GFG();
            Node tree = obj.constructBST(arr);
            preorder(tree);
            System.out.println();
        }
	}
	
	 public static void preorder(Node root){
        if(root == null){
            return;
        }
        
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
}


// } Driver Code Ends


//User function Template for Java


class GFG 
{
    static Node insert(Node root,int key){
        if(root==null) return new Node(key);
        if(root.data<key)
        root.right=insert(root.right,key);
        else
        root.left=insert(root.left,key);
        return root;
    }
    //Function to construct the BST from its given level order traversal.
    public Node constructBST(int[] arr)
    {
        //Write your code here 
        Node node =new Node(arr[0]);
        for(int i=1;i<arr.length;i++){
            insert(node,arr[i]);
        }
        return node;
    }
}