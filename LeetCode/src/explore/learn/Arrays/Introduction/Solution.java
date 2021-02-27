package explore.learn.Arrays.Introduction;

/**
 * LEET CODE
 *  - Explore.Learn.Arrays.Introduction
 * @author 이경민
 *
 */
public class Solution {
	
	/**
	 * Max Consecutive Ones
	 *  - 문제: Given a binary array, find the maximum number of consecutive 1s in this array.
	 * 
	 * Example 1:
		Input: [1,1,0,1,1,1]
		Output: 3
		Explanation: The first two digits or the last three digits are consecutive 1s.
		    The maximum number of consecutive 1s is 3.
	 * 
	 * Note:
		The input array will only contain 0 and 1.
		The length of input array is a positive integer and will not exceed 10,000
	 *
	 * Hint
	 *  - You need to think about two things as far as any window is concerned. One is the starting point for the window. How do you detect that a new window of 1s has started? The next part is detecting the ending point for this window. How do you detect the ending point for an existing window? If you figure these two things out, you will be able to detect the windows of consecutive ones. All that remains afterward is to find the longest such window and return the size.
	 */
	public static int findMaxConsecutiveOnes(int[] nums) {
		int result = 0;
		int max = 0;
		
		for(int num : nums) {
			if(num == 1) {
				result++;
			} else {
				result = 0;
			}
			
			if (result > max) {
				max = result;
			}
		}
		
		return max;
    }

	public static void main(String[] args) {
		int[] inputArr = {1,0,1,1,0,1};
		System.out.println(findMaxConsecutiveOnes(inputArr));
	}

}
