//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			int num = obj.atoi(str);
			
			System.out.println(num);
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    static boolean isnumber(char ch){
        int asciivalue=(int)ch;
        if(asciivalue>=48&&asciivalue<=57){
            return true;  
        }else{
            return false;
        }
    }
    StringBuilder result=new StringBuilder();
    int atoi(String s) {
       for(int i=0;i<s.length();i++){
           char ch=s.charAt(i);
           if(ch=='-'&& i == 0){
               result.append(ch);
           }
           if(isnumber(ch)){
               result.append(ch);
           }
       }
       if(result.length()==s.length()){
          return Integer.parseInt(result.toString());
       }else{
           return -1;
       }
    }
}


