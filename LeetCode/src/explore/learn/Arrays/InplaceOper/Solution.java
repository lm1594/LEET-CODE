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
		
		int maxVal = 0;
		
		if(arr == null) {
			return arr;
		}
		
		if (arr.length < 1) {
			arr[0] = -1;
			return arr;
		}
		
		for (int i=0 ; i<arr.length ; i++) {
			maxVal = arr[arr.length-1];
			for (int j=arr.length-1 ; j>i ; j--) {
				if(arr[j]>maxVal) {
					maxVal = arr[j];
				}
			}
			arr[i] = maxVal;
			if(i == arr.length-1) {
				arr[i] = -1;
			}
		}
		
		for (int num : arr) {
			System.out.println(num);
		}
		
		return arr;
    }
	
	public static void main(String[] args) {
		replaceElements(new int[]{400});
	}

}
