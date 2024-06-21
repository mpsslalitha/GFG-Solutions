//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    String compareFrac(String str) {
        // Code here
        
                int a = 0, b = 0, c = 0, d = 0;

        String regex = "(\\d+)\\/(\\d+), (\\d+)\\/(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            a = Integer.parseInt(matcher.group(1));
            b = Integer.parseInt(matcher.group(2));
            c = Integer.parseInt(matcher.group(3));
            d = Integer.parseInt(matcher.group(4));
        }

        if (a * d > b * c) {
            return a + "/" + b;
        } else if (a * d < b * c) {
            return c + "/" + d;
        } else {
            return "equal";
        }
    }
}

