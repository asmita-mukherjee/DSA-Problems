//Link :https://leetcode.com/problems/combination-sum/

import java.io.*;
import java.util.*;

public class CombinationSum1 
{
    
    
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        public void rec_func(int[]arr , int target , int index,List<Integer>temp)
        {
            if(target == 0)
            { 
                //System.out.println(temp);
                
                result.add(new ArrayList<>(temp));
                
                
                return;
            }
            
            if(index == arr.length)
            {
                return;
            }
            
            //pick the index th element
            if(target-arr[index] >= 0)
            {
                temp.add( arr[index] );
                rec_func(arr , target-arr[index] , index , temp);
                
                //remove the last element from temp since the combination with the last element of temp has been validated
                temp.remove(temp.size()-1);
                
            }
            
            //not pick the index th element
            rec_func(arr , target , index+1 , temp);
            
        }
             
        public List<List<Integer>> combinationSum(int[] candidates, int target) 
        {
            
            rec_func(candidates , target , 0, new ArrayList<Integer>());
    
            return result;
            
        
        }
    
    
    
}
