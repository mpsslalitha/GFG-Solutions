//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class Node
{
	int data;
	Node left, right;

	Node(int val) {
		data = val;
		left = right = null;
	}
}


// } Driver Code Ends
//User function Template for Java

/*Structure of the Node of the BST is as
class Node
{
	int data;
	Node left, right;

	Node(int val) {
		data = val;
		left = right = null;
	}
}
*/

class Solution
{
    
    public static void bfs(Node root, Queue<Integer> q){
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node frontElem = queue.poll();
            int frontData = frontElem.data;
            
            q.add(frontData);
            
            if(frontElem.left != null){
                queue.add(frontElem.left);
            }
            
            if(frontElem.right != null){
                queue.add(frontElem.right);
            }
            
        }
    }
    
    public static int countPairs(Node root1, Node root2, int x){
        // Code here
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
    
        bfs(root1, q1);
        bfs(root2, q2);
    
        // Add all elements from q2 to a HashSet for efficient removal
        set.addAll(q2);
    
        int count = 0;
    
        while (!q1.isEmpty()) {
            int a = q1.poll();
            int b = x - a;
    
            if (set.contains(b)) {
                count++;
                set.remove(b);
            }
        }
    
        return count;
    }
}

//{ Driver Code Starts.

public class Main
{
    static FastIO f;

    // Function to Build Tree
    static Node buildTree(String str)
    {
    	// Corner Case
    	if(str.length() == 0 || str.charAt(0) == 'N')
    		return null;

    	// Creating array of strings from input
    	// string after spliting by space
    	String[] ip = str.split(" ");

    	// Create the root of the tree
    	Node root = new Node(Integer.parseInt(ip[0]));

    	// Push the root to the queue
    	Queue<Node> queue = new LinkedList<>();
    	queue.add(root);

    	// Starting from the second element
	    int i = 1;
	    while (!queue.isEmpty() && i < ip.length) {

	        // Get and remove the front of the queue
	        Node currNode = queue.poll();

	        // Get the current node's value from the string
	        String currVal = ip[i];

	        // If the left child is not null
	        if (!currVal.equals("N")) {

	            // Create the left child for the current Node
	            currNode.left = new Node(Integer.parseInt(currVal));

	            // Push it to the queue
	            queue.add(currNode.left);
	        }

	        // For the right child
	        i++;
	        if (i >= ip.length)
	            break;
	        currVal = ip[i];

	        // If the right child is not null
	        if (!currVal.equals("N")) {

	            // Create the right child for the current node
	            currNode.right = new Node(Integer.parseInt(currVal));

	            // Push it to the queue
	            queue.add(currNode.right);
	        }
	        i++;
	    }

	    return root;
    }
    
    public static void main(String args[]) throws IOException
    {
        f = new FastIO();
        
        int t = f.nextInt();
        
        while(t-->0)
        {
            String tree1 = f.nextLine(), tree2 = f.nextLine();
            Node root1 = buildTree(tree1), root2 = buildTree(tree2);
            int x = f.nextInt();

            f.out(Solution.countPairs(root1, root2, x) + "\n");
        }
        
        f.flush();
    }
}

class FastIO
{
	BufferedReader br;
	PrintWriter bw, be;
	StringTokenizer st;

	public FastIO()
	{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new PrintWriter(System.out);
		be = new PrintWriter(System.err);
		st = new StringTokenizer("");
	}

	private void read() throws IOException
	{
		st = new StringTokenizer(br.readLine());
	}

	public String nextLine() throws IOException
	{
		return br.readLine();
	}

	public String next() throws IOException
	{
		while(!st.hasMoreTokens())
			read();
		return st.nextToken();
	}

	public int nextInt() throws IOException
	{
		return Integer.parseInt(next());
	}

	public long nextLong() throws IOException
	{
		return Long.parseLong(next());
	}

	public float nextFloat() throws IOException
	{
		return Float.parseFloat(next());
	}

	public double nextDouble() throws IOException
	{
		return Double.parseDouble(next());
	}

	public char nextChar() throws IOException
	{
		return next().charAt(0);
	}

	public void out(String s) throws IOException
	{
		bw.print(s);
	}

	public void flush() throws IOException
	{
		bw.flush();
		be.flush();
	}

	public void err(String s) throws IOException
	{
		be.print(s);
	}
}
// } Driver Code Ends