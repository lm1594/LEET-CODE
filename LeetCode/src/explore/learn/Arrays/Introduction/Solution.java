package explore.learn.Arrays.Introduction;

import java.util.Arrays;

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
	
	/**
	 * Find Numbers with Even Number of Digits
	 * - 문제: Given an array nums of integers, return how many of them contain an even number of digits.
	 * 
	 * Example 1:

		Input: nums = [12,345,2,6,7896]
		Output: 2
		Explanation: 
		12 contains 2 digits (even number of digits). 
		345 contains 3 digits (odd number of digits). 
		2 contains 1 digit (odd number of digits). 
		6 contains 1 digit (odd number of digits). 
		7896 contains 4 digits (even number of digits). 
		Therefore only 12 and 7896 contain an even number of digits.
		
	 * Example 2:
		
		Input: nums = [555,901,482,1771]
		Output: 1 
		Explanation: 
		Only 1771 contains an even number of digits.
		
	 * Constraints:

		1 <= nums.length <= 500
		1 <= nums[i] <= 10^5
	 * 
	 * HINT
	 *  - How to compute the number of digits of a number ?
	 *  - Divide the number by 10 again and again to get the number of digits.
	 */
	public static int findNumbers(int[] nums) {
		int divideCnt = 0;
		int resultCnt = 0; 
		
		for (int num : nums) {
			while (num > 9) {
				num /= 10;
				divideCnt++;
			}
			
			if (divideCnt % 2 == 1) {
				resultCnt++;
			}
			divideCnt = 0;
		}
		
        return resultCnt;
    }
	
	/**
	 * Squares of a Sorted Array
	 *  - 문제: Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
	 *  
	 *  Example 1:

		Input: nums = [-4,-1,0,3,10]
		Output: [0,1,9,16,100]
		Explanation: After squaring, the array becomes [16,1,0,9,100].
		After sorting, it becomes [0,1,9,16,100].

		Example 2:
		
		Input: nums = [-7,-3,2,3,11]
		Output: [4,9,9,49,121]
	 * 
	 * Constraints:

		1 <= nums.length <= 104
		-104 <= nums[i] <= 104
		nums is sorted in non-decreasing order.
	 * 
	 * HINT
	 *  - Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
	 */
	public static int[] sortedSquares(int[] nums) {
        // 일반적인 정렬 알고리즘을 이용한 풀이 - 버블정렬 O(n2)
//		int temp = 0;
//		for(int i=0 ; i<nums.length ; i++) {
//			nums[i] = (int) Math.pow(nums[i], 2);
//		}
//		
//		for(int i=0 ; i<nums.length ; i++) {
//			for(int j=i ; j < nums.length ; j++) {
//				if(nums[i] > nums[j]) {
//					temp = nums[i];
//					nums[i] = nums[j];
//					nums[j] = temp;
//				}
//			}
//		}
		
		// Arrays.sort 함수 이용한 풀이 (Merge sort + Insertion sort인 Tim sort) - O(n log (n))
		for(int i=0 ; i<nums.length ; i++) {
			nums[i] = (int) Math.pow(nums[i], 2);
		}
		
		Arrays.sort(nums);
		
		return nums;
    }

	public static void main(String[] args) {
		// Max Consecutive Ones
		// int[] inputArr = {1,0,1,1,0,1};
		// System.out.println(findMaxConsecutiveOnes(inputArr));
		
		// Find Numbers with Even Number of Digits
		// int[] inputArr = {555,901,482,1771};
		// System.out.println(findNumbers(inputArr));
		
		// Squares of a Sorted Array
		int[] inputArr = {-7,-3,2,3,11};
		sortedSquares(inputArr);
	}

}
