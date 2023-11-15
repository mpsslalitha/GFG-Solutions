//{ Driver Code Starts
//Initial Template for Java

import java.util.Scanner;
import java.lang.Math;
import java.io.*;
class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
class GFG2
{
    public static void inorder(Node root)
    {
        if(root==null)
        return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int []post=new int[n];
            for(int i=0;i<n;i++)
            {
                int b=sc.nextInt();
                post[i]=b;
            }
            GFG obj=new GFG();
            Node root=obj.constructTree(post,n);
            inorder(root);
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
/*class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

// Function should return the root of the bst formed using postorder traversal.
class GFG
{
    static int idx;
    public static Node con(int post[], int ll, int hl){
        if(idx == -1 || post[idx] > hl || post[idx] < ll) return null;
        Node root = new Node(post[idx--]);
        root.right = con(post, root.data, hl);
        root.left = con(post, ll, root.data);
        return root;
    }
    public static Node constructTree(int post[],int n)
    {
        //Add your code here.
        int ll = Integer.MIN_VALUE;
        int hl = Integer.MAX_VALUE;
        idx = n - 1;
        return con(post, ll, hl); 
    }
}