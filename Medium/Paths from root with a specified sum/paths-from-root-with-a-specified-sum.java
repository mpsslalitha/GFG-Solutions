//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
} 

public class GfG {
    public static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

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
    

    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        
        int t = Integer.parseInt(scn.nextLine()); 

        while (t-- > 0) 
        {
            int s = Integer.parseInt(scn.nextLine());
            // sc.nextLine();
            String res = scn.nextLine();
            // sc.nextLine();
            Node root = buildTree(res);
            
            Solution ob=new Solution();
            ArrayList<ArrayList<Integer>> ans= ob.printPaths(root, s);
            
            Collections.sort(ans, new ElementWiseComparator());
            
            for(int i=0;i<ans.size();i++)
            {
                for(int j=0;j<ans.get(i).size();j++)
                {
                    System.out.print(ans.get(i).get(j) + " ");
                }
                System.out.println(" ");
            }
        }
    }
    
    static class ElementWiseComparator implements Comparator<ArrayList<Integer>> {
        @Override
        public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
            int minLength = Math.min(list1.size(), list2.size());
    
            for (int i = 0; i < minLength; i++) {
                int comparison = Integer.compare(list1.get(i), list2.get(i));
                if (comparison != 0) {
                    return comparison;
                }
            }
    
            return Integer.compare(list1.size(), list2.size());
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*Tree Node
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
} 
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> printPaths(Node root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        findPaths(root, sum, path, 0, result);
        return result;
    }

    private static void findPaths(Node node, int sum, ArrayList<Integer> path, int currentSum, ArrayList<ArrayList<Integer>> result) {
        if (node == null) {
            return;
        }

        // Add the current node to the path
        currentSum += node.data;
        path.add(node.data);

        // Check if the current path sum equals the target sum
        if (currentSum == sum) {
            result.add(new ArrayList<>(path));
        }

        // Continue to search down to the left and right children
        findPaths(node.left, sum, path, currentSum, result);
        findPaths(node.right, sum, path, currentSum, result);

        // Backtrack: Remove the current node from the path
        path.remove(path.size() - 1);
    }
}