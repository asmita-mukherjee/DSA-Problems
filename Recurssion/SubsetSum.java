// Problem : https://practice.geeksforgeeks.org/problems/subset-sums2234/1


import java.io.*;
import java.util.*;

class SubsetSum
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}
// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{

    
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N)
    {
        
        if(N==0)
        {
            ArrayList<Integer> new_arr = new ArrayList<Integer>();
            
            new_arr.add(0);
            
            return new_arr;
        }
        
        
        ArrayList<Integer> list1 = subsetSums(arr, N-1) ;
        
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        
        for (int i = 0 ;i<list1.size();i++)
        {
            
           int ne = list1.get(i) + arr.get(N-1);
           
           list2.add(ne);
            
        }
        
        list1.addAll(list2); //append the 2 lists
        
        return list1;
        
    }
}