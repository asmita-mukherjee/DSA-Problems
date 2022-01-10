
//https://leetcode.com/problems/subsets-ii/

import java.io.*;
import java.util.*;

class SubsetSum2
{
    
    public List<String> solver(int[] nums ,int index)
    {
        
        if(index == 0) //no further elements in the array 
        {
            List<String> empty_list = new ArrayList<String>();
            
            empty_list.add("");
            
            return empty_list;
        }
        
        //all possible subsets uptill index-1
        List<String> list1 = solver(nums , index-1);
        
        List<String> list2 = new ArrayList<String>() ;
        
        //all possible subsets which must include element at index
        for (int i=0 ; i<list1.size();i++)
        {
         
            String res;
         
            if(list1.get(i) != "")
            {
                //index-1 for 0 indexing
                res = list1.get(i) + ',' + Integer.toString(nums[index-1]);
            }
            
            else
            {
                res = Integer.toString(nums[index-1]);
                
            }
            
            list2.add(res);
            
            
        }
        
        list1.addAll(list2);
        return list1;
        
        
        
    }
    
    
    public List<List<Integer>> subsetsWithDup(int[] nums) 
    {
        
        List<String> result = solver(nums ,nums.length);
        
        //pass to hashset to get unique output.
        HashSet<String> set =new HashSet<String>();  
        
        for (int i = 0 ; i<result.size();i++)
        {
            set.add(result.get(i));
        }
        
        
        List<List<Integer>> ret_res = new ArrayList<List<Integer>>() ;
        
        for (String output:set)
        {
            
            List<Integer> list2 = new ArrayList<Integer>() ;
            
            if(output == "")
            {
                //list2.add();
            }
            
            else
            {
                String[]elem = output.split(",");
                
                for (String num:elem)
                {
                   list2.add(Integer.parseInt(num));
                }
                
                
            }
        
            ret_res.add(list2);
        }
        
        return ret_res;
        
        
    }
}

