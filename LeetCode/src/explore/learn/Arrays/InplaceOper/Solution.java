package explore.learn.Arrays.InplaceOper;


/**
 * LEET CODE
 *  - Explore.Learn.Arrays.In-Place Operations
 * @author 이경민
 *
 */
public class Solution {
	
	/**
	 *  Replace Elements with Greatest Element on Right Side
	 * 문제: Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

		After doing so, return the array.
	 *
	 * Example 1:

		Input: arr = [17,18,5,4,6,1]
		Output: [18,6,6,6,1,-1]
		Explanation: 
		- index 0 --> the greatest element to the right of index 0 is index 1 (18).
		- index 1 --> the greatest element to the right of index 1 is index 4 (6).
		- index 2 --> the greatest element to the right of index 2 is index 4 (6).
		- index 3 --> the greatest element to the right of index 3 is index 4 (6).
		- index 4 --> the greatest element to the right of index 4 is index 5 (1).
		- index 5 --> there are no elements to the right of index 5, so we put -1.
	 * Example 2:
		
		Input: arr = [400]
		Output: [-1]
		Explanation: There are no elements to the right of index 0.
		 
		
	 * Constraints:
		
		1 <= arr.length <= 104
		1 <= arr[i] <= 105
	 *
	 * HINT
	 *  - Loop through the array starting from the end.
	 *  - Keep the maximum value seen so far.
	 */
	public static int[] replaceElements(int[] arr) {
		
//		int maxVal = 0;
//		
//		if(arr == null) {
//			return arr;
//		}
//		
//		if (arr.length < 1) {
//			arr[0] = -1;
//			return arr;
//		}
//		
//		for (int i=0 ; i<arr.length ; i++) {
//			maxVal = arr[arr.length-1];
//			for (int j=arr.length-1 ; j>i ; j--) {
//				if(arr[j]>maxVal) {
//					maxVal = arr[j];
//				}
//			}
//			arr[i] = maxVal;
//			if(i == arr.length-1) {
//				arr[i] = -1;
//			}
//		}
//		
//		for (int num : arr) {
//			System.out.println(num);
//		}
//		
//		return arr;
		
		// 개선 답안
		if(arr.length==1) {
			return new int[]{-1};
		}
			
		int max=Integer.MIN_VALUE;
        int a[]=new int[arr.length];
	    
	    for(int i=arr.length-2 ; i>=0 ; i--){
	    	a[i]=Math.max(arr[i+1],max);
	    	max=Math.max(arr[i+1],max);
	    }
	    
	    a[arr.length-1]=-1;
	    
	    return a;
    }
	
	/**
	 * Move Zeroes
	 *  - 문제: Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

		Note that you must do this in-place without making a copy of the array.
	 *
	 * Example 1:

		Input: nums = [0,1,0,3,12]
		Output: [1,3,12,0,0]
		Example 2:
		
		Input: nums = [0]
		Output: [0]
	 
	
	 * Constraints:
	
		1 <= nums.length <= 104
		-231 <= nums[i] <= 231 - 1
		 
		
		Follow up: Could you minimize the total number of operations done?
	 */
	public static void moveZeroes(int[] nums) {
        
//		int writePointer = nums.length-1;
//		int tempNum = 0;
//	
//		for(int readPointer=0 ; readPointer<nums.length ; readPointer++) {
//			if(nums[readPointer] == 0) {
//				
//				for(int i=readPointer ; i<nums.length ; i++) {
//					if(nums[i] != 0) {
//						writePointer = i;
//						break;
//					}
//				}
//				
//				tempNum = nums[readPointer];
//				nums[readPointer] = nums[writePointer];
//				nums[writePointer] = tempNum;
//			}
//			
//			if(readPointer >= writePointer) {
//				break;
//			}
//		}
		
		// 개선 답안
		int cnt = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                cnt++;
            } else {
                nums[i - cnt] = nums[i];
            }
        }
        
        for(int i = nums.length - cnt; cnt > 0; cnt--, i++) {
            nums[i] = 0;
        }
    }
	
	public static void main(String[] args) {
		moveZeroes(new int[] {1,0,1});
	}

}
