//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) list.add(sc.nextInt());

            Solution obj = new Solution();
            long ans = obj.findMaxProduct(list);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {

    public static double mod=1e9+7;

    public long findMaxProduct(List<Integer> arr) {

        // code here

        long product=0;

 

        ArrayList<Integer> neg=new ArrayList<Integer>();

        

        for (int i : arr) {

            

            if(i<0) neg.add(i);

            

            else if (i>0) {

                if(product==0) product=1;

                product=(long)((product*i)%mod);

            }

        }

        

        Collections.sort(neg);

 

        if(neg.size()>1) { 

            for (int i=1;i<neg.size();i+=2) { 

                if(product==0) product=1;

                product=(long)((product*neg.get(i)*neg.get(i-1))%mod);

            }

        }

        return product;

    }

}

