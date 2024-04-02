//{ Driver Code Starts
import java.io.*;
import java.util.*;


class StringArray
{
    public static String[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }
    
    public static void print(String[] a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<String> a)
    {
        for(int i = 0; i < a.size()-1; i++)
            System.out.print(a.get(i)+" ");
        System.out.println(a.get(a.size()-1));
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            ArrayList<String> res = obj.removeInvalidParentheses(s);
            
            StringArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int countInvalidCount(String str) {
		int open = 0;
		int invalidClose = 0;
		for (char ch : str.toCharArray()) {
			if (ch == '(') {
				open++;
			} else if (ch == ')') {
				if (open > 0) {
					open--;
				} else {
					invalidClose++;
				}
			}
		}
		return open + invalidClose;
	}

	public static void backtracking(String str, int index, int open, int removed, int invalidCount, StringBuilder sb,
			Set<String> ans) {
		if (index == str.length() && open == 0) {
			ans.add(sb.toString());
			return;
		}
		if (index == str.length() || removed > invalidCount) {
			return;
		}
		if (str.charAt(index) == '(') {
			sb.append(str.charAt(index));
			backtracking(str, index + 1, open + 1, removed, invalidCount, sb, ans); // use '('
			sb.deleteCharAt(sb.length() - 1);
			backtracking(str, index + 1, open, removed + 1, invalidCount, sb, ans);// not use '('
		} else if (str.charAt(index) == ')') {
			if (open > 0) {
				sb.append(str.charAt(index));
				backtracking(str, index + 1, open - 1, removed, invalidCount, sb, ans);// use ')'
				sb.deleteCharAt(sb.length() - 1);
			}
			backtracking(str, index + 1, open, removed + 1, invalidCount, sb, ans); // not use ')'
		} else {
			sb.append(str.charAt(index));
			backtracking(str, index + 1, open, removed, invalidCount, sb, ans);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
    public static ArrayList<String> removeInvalidParentheses(String s) {
        int invalidCount = countInvalidCount(s);
		Set<String> set = new HashSet<>();
		backtracking(s, 0, 0, 0, invalidCount, new StringBuilder(), set);
		ArrayList<String> ans = new ArrayList<String>(set);
		Collections.sort(ans);
		return ans;
    }
}    
