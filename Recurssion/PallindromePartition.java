// Link : https://leetcode.com/problems/palindrome-partitioning/

import java.io.*;
import java.util.*;

class PallindromePartition {
    public List<List<String>> partition(String s) 
    {
        List<List<String>> result = new ArrayList<List<String>>();
        
        back_track_partition(s,0,new ArrayList<String>(),result);
        
        return result;
    }
    
    void back_track_partition(String s , int start , List<String>temp, List<List<String>>result)
    {
        if(start == s.length())
        {
            result.add(new ArrayList<String>(temp));
        }
        
        for(int index = start ; index<s.length(); index++)
        {
            if(checkPallindrome(s,start,index))
            {
                
                temp.add(s.substring(start,index+1));
                
                //once we have partitoned at the indexth positon , we are trying for the next positon
                back_track_partition(s,index+1,temp,result);
                
                //once we have explored the entire dfs branch , we backtrack
                temp.remove(temp.size()-1);
                
            }
        }
        
        
    }
    
    boolean checkPallindrome(String s , int start , int end)
    {
        while(start<end)
        {
            if(s.charAt(start++) != s.charAt(end--))
            {
                return false;
            }
        }
        
        return true;
           
    }
    
    
}