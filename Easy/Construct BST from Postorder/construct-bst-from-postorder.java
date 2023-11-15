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
    // public static Node con(int[] post, int i, int b){
    //     if(i < 0 || post[i]<b) return null;
    //     Node root = new Node(post[i--]);
    //     root.right = con(post, i, root.data);
    //     root.left = con(post, i, b);
    //     return root;
    // }
    // public static Node constructTree(int post[],int n)
    // {
    //     //Add your code here.
    //     int i = n - 1;
    //     return con(post,i, Integer.MIN_VALUE);
    // }
    public static Node constructTree(int post[],int n)

    {

        //Add your code here.

        return construct(post, 0, n-1);

    }

    

    //in postorder array root is always at last

    //so basically the idea is to store last element as root

    //travesres back in the array find the first smallest then root elemetn index

    //from start to first smallest eleemtn will be left subtree

    //from first smallest ele + 1 index to end-1 will be right subtree

    //now recursively do the above steps for subtrees until start index is smaller than end

    private static Node construct(int arr[], int start, int end){

        if(start>end)

            return null;

            

        Node node=new Node(arr[end]);

        int i;

        

        for(i=end-1; i>=start; i--){

            if(arr[i]<node.data)

                break;

        }

        

        node.left=construct(arr, start, i);

        node.right=construct(arr, i+1, end-1);

        

        return node;

    }


}