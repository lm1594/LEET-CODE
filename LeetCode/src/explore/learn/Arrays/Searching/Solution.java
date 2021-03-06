package explore.learn.Arrays.Searching;

import java.util.Hashtable;

/**
 * LEET CODE
 *  - Explore.Learn.Arrays.Searching
 * @author 이경민
 *
 */
public class Solution {
	
	/**
	 * Check If N and Its Double Exist
	 * - 문제: Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).

		More formally check if there exists two indices i and j such that :
		
		i != j
		0 <= i, j < arr.length
		arr[i] == 2 * arr[j]
	 *	
	 * Example 1:
			
			Input: arr = [10,2,5,3]
			Output: true
			Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
	 * Example 2:
			
			Input: arr = [7,1,14,11]
			Output: true
			Explanation: N = 14 is the double of M = 7,that is, 14 = 2 * 7.
	 * Example 3:
			
			Input: arr = [3,1,7,11]
			Output: false
			Explanation: In this case does not exist N and M, such that N = 2 * M.
	 *
	 * Constraints:
			
			2 <= arr.length <= 500
			-10^3 <= arr[i] <= 10^3
	 *
	 * HINT
	 *  - Loop from i = 0 to arr.length, maintaining in a hashTable the array elements from [0, i - 1].
	 *  - On each step of the loop check if we have seen the element 2 * arr[i] so far or arr[i] / 2 was seen if arr[i] % 2 == 0.
	 */
	public static boolean checkIfExist(int[] arr) {
		// 일반적인 풀이 (O(N^2))
//		boolean result = false;
//		
//        for(int i=0 ; i<arr.length ; i++) {
//        	if(arr[i] % 2 == 0) {
//        		for(int j = 0; j<arr.length ; j++) {
//        			if(i!=j && arr[j] * 2 == arr[i]) {
//        				return true;
//        			}
//        		}
//        	}
//        }
//        return result;
        
        // HashTable을 이용한 풀이 (O(N))
        if (arr == null || arr.length == 0) {
            return false;
        }
        
        Hashtable t = new Hashtable();
        
        for (int i = 0; i < arr.length; i++) {
            if (t.contains(arr[i] * 2)
               || (arr[i] % 2 == 0 && t.contains(arr[i] / 2))) {
                return true;
            }
            t.put(i, arr[i]);
        }
        return false;
    }
	
	public static void main(String[] args) {
		int[] inputArr = {10,2,5,3};
		System.out.println(checkIfExist(inputArr));
	}

}
