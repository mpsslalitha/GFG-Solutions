//{ Driver Code Starts
// Initial Template for Java
import java.util.*;

class Tree {
    int data;
    Tree left;
    Tree right;

    Tree(int d) {
        data = d;
        left = null;
        right = null;
    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}


// } Driver Code Ends
// User function Template for Java
class Solution {
    class Pair{
        Tree node;
        int idx;
        public Pair(Tree node,int idx){
            this.node=node;
            this.idx=idx;
        }
    }
    public Tree convert(Node head, Tree node) {
        Node tmp=head;
        ArrayList<Integer> a=new ArrayList<>();
        while(tmp!=null){
            a.add(tmp.data);
            tmp=tmp.next;
        }
        Queue<Pair> q=new ArrayDeque<>();
        Tree root=new Tree(a.get(0));
        q.add(new Pair(root,0));
        while(q.size()>0){
            Pair p=q.remove();
            Tree nodee=p.node;
            int i=p.idx;
            if(2*i+1>=a.size()){
                nodee.left=null;
                nodee.right=null;
            }else{
                if(2*i+1<a.size()){
                    Tree left=new Tree(a.get(2*i+1));
                    nodee.left=left;
                    q.add(new Pair(left,2*i+1));
                }
                if(2*i+2<a.size()){
                    Tree right=new Tree(a.get(2*i+2));
                    nodee.right=right;
                    q.add(new Pair(right,2*i+2));
                }
            }
        }
        return root;
        
    }
}


//{ Driver Code Starts.
class GFG {
    static Node lhead;
    static Queue<Tree> queue = new LinkedList<Tree>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Tree node = null;
            lhead = null;
            Node head = null;
            while (!queue.isEmpty()) {
                queue.poll();
            }
            int n = sc.nextInt();
            if (n != 0) {
                GFG llist = new GFG();
                int a1 = sc.nextInt();
                head = new Node(a1);
                llist.addToTheLast(head);
                lhead = head;
                for (int i = 1; i < n; i++) {
                    int a = sc.nextInt();
                    llist.addToTheLast(new Node(a));
                }
            }
            Solution g = new Solution();
            Tree root = g.convert(lhead, node);
            try {
                levelOrder(root, n);
            } catch (NullPointerException ex) {
                System.out.println(-1);
            }
            System.out.println();
        }
    }

    public static void levelOrder(Tree root, int n) {
        queue.add(root);
        while (!queue.isEmpty() && n-- > 0) {
            Tree proot = queue.remove();
            try {
                queue.add(proot.left);
                queue.add(proot.right);
                System.out.print(proot.data + " ");
            } catch (NullPointerException ex) {
            }
        }
    }

    public void addToTheLast(Node head) {
        if (lhead == null)
            lhead = head;
        else {
            Node temp = lhead;
            while (temp.next != null) temp = temp.next;
            temp.next = head;
        }
    }
}
// } Driver Code Ends